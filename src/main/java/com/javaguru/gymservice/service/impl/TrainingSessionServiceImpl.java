package com.javaguru.gymservice.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaguru.gymservice.domain.Coach;
import com.javaguru.gymservice.domain.ExerciseSession;
import com.javaguru.gymservice.domain.Gym;
import com.javaguru.gymservice.exception.ModelNotFoundException;
import com.javaguru.gymservice.model.request.WeekDayRequest;
import com.javaguru.gymservice.model.response.*;
import com.javaguru.gymservice.repositories.CoachRepository;
import com.javaguru.gymservice.repositories.ExerciseSessionRepository;
import com.javaguru.gymservice.service.TrainingSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 * @time: 2:46 AM
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingSessionServiceImpl implements TrainingSessionService {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final CoachRepository coachRepository;
    private final ExerciseSessionRepository exerciseSessionRepository;

    @Override
    public TrainingSessions getAllTrainingSession() {
        List<ExerciseSession> exerciseSessions = exerciseSessionRepository.findAll();
        return buildTrainingSessions(exerciseSessions);
    }

    @Override
    public TrainingSessions getTrainingSessionForCoach(String coachId, WeekDayRequest weekDayRequest) {
        log.info("coachId: {}; weekDayRequest: {}", coachId, gson.toJson(weekDayRequest));
        Coach byId = coachRepository.findById(coachId)
                .orElseThrow(() -> new ModelNotFoundException("Coach does not exist"));

        List<ExerciseSession> byCoachAndExerciseDayIn = exerciseSessionRepository
                .findByCoachAndExerciseDayIn(byId, Arrays.asList(weekDayRequest.getWeekDays()));
        return buildTrainingSessions(byCoachAndExerciseDayIn);
    }

    private TrainingSessions buildTrainingSessions(List<ExerciseSession> exerciseSessions){
        List<SingleTrainingSession> trainingSessions = new ArrayList<>();
        exerciseSessions
                .forEach(exerciseSession -> {
                    CoachResp coachResp = CoachResp.builder()
                            .id(exerciseSession.getCoach().getId())
                            .name(exerciseSession.getCoach().getFirstName())
                            .build();

                    GymResp gymResp = GymResp.builder()
                            .id(exerciseSession.getGym().getId())
                            .name(exerciseSession.getGym().getGymName())
                            .build();

                    MemberResp memberResp = MemberResp.builder()
                            .id(exerciseSession.getMember().getId())
                            .name(exerciseSession.getMember().getFirstName())
                            .build();

                    TrainingSession trainingSession = TrainingSession.builder()
                            .coach(coachResp)
                            .gym(gymResp)
                            .member(memberResp)
                            .weekday(exerciseSession.getExerciseDay().name())
                            .build();

                    SingleTrainingSession singleTrainingSession = SingleTrainingSession.builder()
                            .trainingSession(trainingSession)
                            .build();

                    trainingSessions.add(singleTrainingSession);
                });

        return TrainingSessions.builder()
                .trainingSessions(trainingSessions)
                .build();

    }
}

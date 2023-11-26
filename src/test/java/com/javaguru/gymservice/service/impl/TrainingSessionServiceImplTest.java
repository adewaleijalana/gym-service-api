package com.javaguru.gymservice.service.impl;

import com.javaguru.gymservice.TestObjects;
import com.javaguru.gymservice.domain.Coach;
import com.javaguru.gymservice.domain.ExerciseSession;
import com.javaguru.gymservice.exception.ModelNotFoundException;
import com.javaguru.gymservice.model.request.SearchSessionRequest;
import com.javaguru.gymservice.model.response.TrainingSessions;
import com.javaguru.gymservice.repositories.CoachRepository;
import com.javaguru.gymservice.repositories.ExerciseSessionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/26/23
 **/

@ExtendWith(MockitoExtension.class)
class TrainingSessionServiceImplTest {

    @Mock
    CoachRepository coachRepository;

    @Mock
    ExerciseSessionRepository exerciseSessionRepository;

    @InjectMocks
    TrainingSessionServiceImpl trainingSessionService;


    @Test
    void getAllTrainingSession() {
        List<ExerciseSession> exerciseSessions = TestObjects.getExerciseSessions();
        given(exerciseSessionRepository.findAll())
                .willReturn(exerciseSessions);
        TrainingSessions allTrainingSession = trainingSessionService.getAllTrainingSession();

        assertThat(allTrainingSession).isNotNull();
    }

    @Test
    void getTrainingSessionForCoach_ModelNotFoundException() {
        SearchSessionRequest searchSessionRequest = TestObjects.buildSearchSessionRequest();
        given(coachRepository.findByFirstName(anyString()))
                .willReturn(Optional.empty());

        ModelNotFoundException modelNotFoundException = assertThrows(ModelNotFoundException.class, () -> {
            trainingSessionService
                    .getTrainingSessionForCoach(searchSessionRequest);
        });

        assertThat(modelNotFoundException.getArgumentSupplied())
                .contains("Coach does not exist");
    }

    @Test
    void getTrainingSessionForCoach_successful() {
        Coach coach = TestObjects.buildCoach();
        SearchSessionRequest searchSessionRequest = TestObjects.buildSearchSessionRequest();
        given(coachRepository.findByFirstName(anyString()))
                .willReturn(Optional.of(coach));

        TrainingSessions trainingSessionForCoach = trainingSessionService
                .getTrainingSessionForCoach(searchSessionRequest);

        assertThat(trainingSessionForCoach).isNotNull();
    }

//    @Test
//    void getTrainingSessionForOtherDaysThanWed() {
//    }
}
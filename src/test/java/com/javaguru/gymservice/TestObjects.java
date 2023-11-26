package com.javaguru.gymservice;

import com.javaguru.gymservice.constants.ExerciseDays;
import com.javaguru.gymservice.domain.Coach;
import com.javaguru.gymservice.domain.ExerciseSession;
import com.javaguru.gymservice.domain.Gym;
import com.javaguru.gymservice.domain.Member;
import com.javaguru.gymservice.model.request.SearchSessionRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/26/23
 **/


public class TestObjects {

    public static List<ExerciseSession> getExerciseSessions(){
        List<ExerciseSession> exerciseSessions = new ArrayList<>();
        exerciseSessions.add(ExerciseSession.builder()
                .member(Member.builder()
                        .phoneNumber("1234")
                        .lastName("test-01")
                        .firstName("test-01")
                        .email("test-01@test.com")
                        .build())
                .gym(Gym.builder()
                        .gymName("test-gym")
                        .build())
                .exerciseDay(ExerciseDays.MON)
                .coach(Coach.builder()
                        .phoneNumber("1234")
                                .lastName("coach-01")
                                .firstName("coach-01")
                                .email("coach-01@test.com")
                        .build())
                .build());
        return  exerciseSessions;
    }

    public static SearchSessionRequest buildSearchSessionRequest(){
        return SearchSessionRequest.builder()
                .coachName("test-or")
                .weekDays(new ExerciseDays[]{ExerciseDays.MON})
                .build();
    }

    public static Coach buildCoach(){
        return Coach.builder()
                .phoneNumber("1234")
                .lastName("coach-01")
                .firstName("coach-01")
                .email("coach-01@test.com")
                .build();
    }
}

package com.javaguru.gymservice.service;

import com.javaguru.gymservice.constants.ExerciseDays;
import com.javaguru.gymservice.model.response.TrainingSessionCountResponse;
import com.javaguru.gymservice.model.response.TrainingSessions;

import java.util.List;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 * @time: 2:46AM
 **/


public interface TrainingSessionService {
    TrainingSessions getAllTrainingSession();

    TrainingSessions getTrainingSessionForCoach(String coachName, List<ExerciseDays> weekDays);

    TrainingSessionCountResponse getTrainingSessionForOtherDaysThanWed();
}

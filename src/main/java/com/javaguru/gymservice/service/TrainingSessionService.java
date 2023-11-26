package com.javaguru.gymservice.service;

import com.javaguru.gymservice.model.request.WeekDayRequest;
import com.javaguru.gymservice.model.response.TrainingSessionCountResponse;
import com.javaguru.gymservice.model.response.TrainingSessions;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 * @time: 2:46AM
 **/


public interface TrainingSessionService {
    TrainingSessions getAllTrainingSession();

    TrainingSessions getTrainingSessionForCoach(String coachName, WeekDayRequest weekDayRequest);

    TrainingSessionCountResponse getTrainingSessionForOtherDaysThanWed();
}

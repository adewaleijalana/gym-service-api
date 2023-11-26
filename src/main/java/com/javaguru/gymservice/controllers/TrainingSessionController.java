package com.javaguru.gymservice.controllers;

import com.javaguru.gymservice.constants.ExerciseDays;
import com.javaguru.gymservice.model.request.SearchSessionRequest;
import com.javaguru.gymservice.model.response.TrainingSessionCountResponse;
import com.javaguru.gymservice.model.response.TrainingSessions;
import com.javaguru.gymservice.service.TrainingSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 **/

@Slf4j
@RestController
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(value = "/api/training-session")
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    @GetMapping()
    public ResponseEntity<TrainingSessions> searchForTrainingSession(){
        return new ResponseEntity<>(trainingSessionService.getAllTrainingSession(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<TrainingSessions> searchForTrainingSession(
            @RequestParam("coachName") String coachName, @RequestParam List<ExerciseDays> values){
        log.info("coach name: {}; days: {}", coachName, values);
        return new ResponseEntity<>(trainingSessionService
                .getTrainingSessionForCoach(coachName, values), HttpStatus.OK);
    }

    @GetMapping("/count")
    ResponseEntity<TrainingSessionCountResponse> getAllTrainingSessionForOtherDaysThanWed(){
        return new ResponseEntity<>(trainingSessionService
                .getTrainingSessionForOtherDaysThanWed(), HttpStatus.OK);
    }
}

package com.javaguru.gymservice.controllers;

import com.javaguru.gymservice.model.response.TrainingSessions;
import com.javaguru.gymservice.service.TrainingSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 * @time: 2:39 AM
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
    ResponseEntity<TrainingSessions> getAllTrainingSession(){
        return new ResponseEntity<>(trainingSessionService.getAllTrainingSession(), HttpStatus.OK);
    }
}

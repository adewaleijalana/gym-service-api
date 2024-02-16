package com.javaguru.gymservice.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaguru.gymservice.TestObjects;
import com.javaguru.gymservice.model.request.SearchSessionRequest;
import com.javaguru.gymservice.model.response.TrainingSessions;
import com.javaguru.gymservice.service.TrainingSessionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/26/23
 **/

@Slf4j
@WebMvcTest(TrainingSessionController.class)
class TrainingSessionControllerTest {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainingSessionService trainingSessionService;

    @Test
    void getAllTrainingSession() throws Exception {
        TrainingSessions trainingSessions = TestObjects.buildTrainingSessions();
        given(trainingSessionService.getAllTrainingSession())
                .willReturn(trainingSessions);

        this.mockMvc
                .perform(get("/api/training-session"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainingSessions").isArray())
                .andExpect(jsonPath("$.trainingSessions", hasSize(trainingSessions.getTrainingSessions().size())));
    }

    @Test
    void searchForTrainingSession() throws Exception {
        TrainingSessions trainingSessions = TestObjects.buildTrainingSessions();
        SearchSessionRequest searchSessionRequest = TestObjects.buildSearchSessionRequest();
        given(trainingSessionService.getTrainingSessionForCoach(searchSessionRequest.getCoachName(),
                Arrays.asList(searchSessionRequest.getWeekDays())))
                .willReturn(trainingSessions);

        this.mockMvc
                .perform(get("/api/training-session/search")
                .param("coachName", searchSessionRequest.getCoachName())
                .param("weekDays", "WED"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
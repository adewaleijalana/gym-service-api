
package com.javaguru.gymservice.model.response;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSessions {

    private List<SingleTrainingSession> trainingSessions;

}

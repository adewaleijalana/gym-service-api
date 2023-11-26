package com.javaguru.gymservice.model.response;

import lombok.*;

import java.io.Serializable;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 **/

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSessionCountResponse implements Serializable {

    private int trainingSessionCount;
}

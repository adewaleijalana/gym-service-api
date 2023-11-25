package com.javaguru.gymservice.advise;

import lombok.*;

import java.util.List;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse {

    private ErrorCode error;
    private String message;
    private List<String> errorMessages;
}

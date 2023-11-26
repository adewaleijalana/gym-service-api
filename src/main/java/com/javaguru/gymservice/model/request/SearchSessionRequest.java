package com.javaguru.gymservice.model.request;

import com.javaguru.gymservice.constants.ExerciseDays;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 * @time: 8:34AM
 **/

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchSessionRequest implements Serializable {

    private static final long serialVersionUID = 2919923324991011979L;
    private String coachName;
    private ExerciseDays [] weekDays;

    @Override
    public String toString() {
        return "WeekDayRequest{" +
                "weekDays=" + Arrays.toString(weekDays) +
                '}';
    }
}

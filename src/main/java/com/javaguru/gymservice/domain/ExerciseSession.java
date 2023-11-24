package com.javaguru.gymservice.domain;

import com.javaguru.gymservice.constants.ExerciseDays;
import com.javaguru.gymservice.domain.extra.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 2:10PM
 **/

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercise_session")
public class ExerciseSession extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -3613736495798174054L;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "exercise_day")
    private ExerciseDays exerciseDay;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExerciseSession that = (ExerciseSession) o;
        return Objects.equals(coach, that.coach)
                && Objects.equals(member, that.member)
                && exerciseDay == that.exerciseDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, member, exerciseDay);
    }
}

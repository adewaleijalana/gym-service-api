package com.javaguru.gymservice.domain;

import com.javaguru.gymservice.domain.extra.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 10:15PM
 **/


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gym_coach")
@EntityListeners(AuditingEntityListener.class)
public class GymCoach extends AbstractBaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GymCoach gymCoach = (GymCoach) o;
        return Objects.equals(gym, gymCoach.gym) && Objects.equals(coach, gymCoach.coach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gym, coach);
    }
}

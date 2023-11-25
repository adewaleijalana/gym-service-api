package com.javaguru.gymservice.domain;

import com.javaguru.gymservice.domain.extra.AbstractBaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 10:10PM
 **/

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gym")
@EntityListeners(AuditingEntityListener.class)
public class Gym extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 4363909427237237585L;

    @Column(name = "gym_name", nullable = false)
    private String gymName;

    @OneToMany(mappedBy = "gym")
    private Set<GymCoach> gymCoachSet;

    @OneToMany(mappedBy = "gym")
    private Set<ExerciseSession> exerciseSessionSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gym gym = (Gym) o;
        return Objects.equals(gymName, gym.gymName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gymName);
    }
}

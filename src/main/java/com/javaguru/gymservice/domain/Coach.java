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
 * @time: 2:10PM
 **/

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coach")
@EntityListeners(AuditingEntityListener.class)
public class Coach extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 7702825964214396020L;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "coach")
    private Set<ExerciseSession> exerciseSessionSet;

    @OneToMany(mappedBy = "coach")
    private Set<GymCoach> gymCoachSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coach coach = (Coach) o;
        return Objects.equals(firstName, coach.firstName)
                && Objects.equals(lastName, coach.lastName)
                && Objects.equals(email, coach.email)
                && Objects.equals(phoneNumber, coach.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }
}

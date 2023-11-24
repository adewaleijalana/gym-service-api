package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.domain.ExerciseSession;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 2:38 PM
 **/


public interface ExerciseSessionRepository extends JpaRepository<ExerciseSession, Long> {
}

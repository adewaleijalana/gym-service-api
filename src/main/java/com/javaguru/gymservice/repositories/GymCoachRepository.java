package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.domain.GymCoach;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 10:51PM
 **/


public interface GymCoachRepository extends JpaRepository<GymCoach, String> {
}

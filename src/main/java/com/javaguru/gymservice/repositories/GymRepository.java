package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.domain.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 10:50PM
 **/


public interface GymRepository extends JpaRepository<Gym, String> {
}

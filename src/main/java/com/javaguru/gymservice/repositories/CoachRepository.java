package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 2:35PM
 **/


public interface CoachRepository extends JpaRepository<Coach, String> {
}

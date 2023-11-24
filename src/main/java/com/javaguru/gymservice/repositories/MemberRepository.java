package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 2:37PM
 **/


public interface MemberRepository extends JpaRepository<Member, String> {
}

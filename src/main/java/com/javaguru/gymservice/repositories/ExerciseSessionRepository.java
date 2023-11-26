package com.javaguru.gymservice.repositories;

import com.javaguru.gymservice.constants.ExerciseDays;
import com.javaguru.gymservice.domain.Coach;
import com.javaguru.gymservice.domain.ExerciseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 **/


public interface ExerciseSessionRepository extends JpaRepository<ExerciseSession, String> {

    @Query("select e from ExerciseSession e where e.coach = :coachId and e.exerciseDay in :exerciseDays")
    List<ExerciseSession> findByCoachAndExerciseDayIn(@Param("coachId") Coach coachId,
                                                      @Param("exerciseDays") Collection<ExerciseDays> exerciseDays);

    @Query("select e from ExerciseSession e where e.exerciseDay not in :exerciseDays")
    List<ExerciseSession> findByExerciseDayIsNotIn(@Param("exerciseDays") Collection<ExerciseDays> exerciseDays);
}

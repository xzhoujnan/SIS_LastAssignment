package com.example.sis.repository;

import com.example.sis.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByStudentStudentId(Long studentId);

    // Native query to take top 5 by computed grade (works for H2/MySQL etc.)
    @Query(value = "SELECT * FROM scores s WHERE s.subject_id = :subjectId ORDER BY (0.3 * COALESCE(s.score1,0) + 0.7 * COALESCE(s.score2,0)) DESC LIMIT :limit", nativeQuery = true)
    List<Score> findTopBySubjectOrderByGradeDesc(@Param("subjectId") Long subjectId, @Param("limit") int limit);

    // Fallback: all scores by subject (JPQL) in case needed
    @Query("select s from Score s where s.subject.subjectId = :subjectId order by (0.3 * s.score1 + 0.7 * s.score2) desc")
    List<Score> findBySubjectOrderByComputedGradeDesc(@Param("subjectId") Long subjectId);
}

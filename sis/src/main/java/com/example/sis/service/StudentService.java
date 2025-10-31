package com.example.sis.service;

import com.example.sis.dto.StudentCreateRequest;
import com.example.sis.dto.StudentDTO;
import com.example.sis.dto.ScoreDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentCreateRequest request);
    StudentDTO getStudentWithScores(Long studentId);
    List<ScoreDTO> getTop5BySubject(Long subjectId);
}

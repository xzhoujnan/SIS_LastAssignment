package com.example.sis.service.impl;

import com.example.sis.dto.ScoreDTO;
import com.example.sis.dto.StudentCreateRequest;
import com.example.sis.dto.StudentDTO;
import com.example.sis.entity.Score;
import com.example.sis.entity.Student;
import com.example.sis.entity.Subject;
import com.example.sis.repository.ScoreRepository;
import com.example.sis.repository.StudentRepository;
import com.example.sis.repository.SubjectRepository;
import com.example.sis.service.StudentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;

    public StudentServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public StudentDTO createStudent(StudentCreateRequest request) {
        Student s = Student.builder()
                .studentCode(request.getStudentCode())
                .fullName(request.getFullName())
                .address(request.getAddress())
                .build();
        Student saved = studentRepository.save(s);
        return StudentDTO.builder()
                .studentId(saved.getStudentId())
                .studentCode(saved.getStudentCode())
                .fullName(saved.getFullName())
                .address(saved.getAddress())
                .scores(Collections.emptyList())
                .build();
    }

    @Override
    @Cacheable(value = "student", key = "#studentId")
    public StudentDTO getStudentWithScores(Long studentId) {
        Optional<Student> opt = studentRepository.findById(studentId);
        if (opt.isEmpty()) return null;
        Student s = opt.get();

        List<Score> scores = scoreRepository.findByStudentStudentId(studentId);
        List<ScoreDTO> scoreDTOS = scores.stream()
                .map(this::toScoreDTO)
                .collect(Collectors.toList());

        return StudentDTO.builder()
                .studentId(s.getStudentId())
                .studentCode(s.getStudentCode())
                .fullName(s.getFullName())
                .address(s.getAddress())
                .scores(scoreDTOS)
                .build();
    }

    @Override
    @Cacheable(value = "top5", key = "#subjectId")
    public List<ScoreDTO> getTop5BySubject(Long subjectId) {
        // Try native-limit query first
        List<Score> list = scoreRepository.findTopBySubjectOrderByGradeDesc(subjectId, 5);
        if (list == null || list.isEmpty()) {
            // fallback to JPQL and trim
            List<Score> all = scoreRepository.findBySubjectOrderByComputedGradeDesc(subjectId);
            list = all.stream().limit(5).collect(Collectors.toList());
        }
        return list.stream().map(this::toScoreDTO).collect(Collectors.toList());
    }

    private ScoreDTO toScoreDTO(Score s) {
        Subject subj = s.getSubject();
        Double grade = s.getGrade();
        return ScoreDTO.builder()
                .id(s.getId())
                .subjectId(subj != null ? subj.getSubjectId() : null)
                .subjectName(subj != null ? subj.getSubjectName() : null)
                .score1(s.getScore1())
                .score2(s.getScore2())
                .grade(grade)
                .letter(s.getLetterGrade())
                .build();
    }
}

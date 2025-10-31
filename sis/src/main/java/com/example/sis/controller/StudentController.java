package com.example.sis.controller;

import com.example.sis.dto.ScoreDTO;
import com.example.sis.dto.StudentCreateRequest;
import com.example.sis.dto.StudentDTO;
import com.example.sis.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentCreateRequest request) {
        if (request.getStudentCode() == null || request.getStudentCode().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        StudentDTO created = studentService.createStudent(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentWithScores(@PathVariable("id") Long id) {
        StudentDTO dto = studentService.getStudentWithScores(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/subjects/{subjectId}/top5")
    public ResponseEntity<List<ScoreDTO>> getTop5BySubject(@PathVariable("subjectId") Long subjectId) {
        List<ScoreDTO> list = studentService.getTop5BySubject(subjectId);
        return ResponseEntity.ok(list);
    }
}

package com.example.sis.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long studentId;
    private String studentCode;
    private String fullName;
    private String address;
    private List<ScoreDTO> scores;
}

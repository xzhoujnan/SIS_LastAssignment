package com.example.sis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreDTO {
    private Long id;
    private Long subjectId;
    private String subjectName;
    private Double score1;
    private Double score2;
    private Double grade;
    private String letter;
}

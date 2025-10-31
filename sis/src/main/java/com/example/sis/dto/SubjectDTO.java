package com.example.sis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDTO {
    private Long subjectId;
    private String subjectCode;
    private String subjectName;
    private Integer credit;
}

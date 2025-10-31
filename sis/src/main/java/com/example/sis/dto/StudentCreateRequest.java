package com.example.sis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {
    private String studentCode;
    private String fullName;
    private String address;
}

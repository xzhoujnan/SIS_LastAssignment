package com.example.sis.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "scores", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id","subject_id"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private Double score1;
    private Double score2;

    public Double getGrade() {
        double s1 = score1 == null ? 0.0 : score1;
        double s2 = score2 == null ? 0.0 : score2;
        return 0.3 * s1 + 0.7 * s2;
    }

    public String getLetterGrade() {
        double g = getGrade();
        if (g >= 8.0) return "A";
        if (g >= 6.0) return "B";
        if (g >= 4.0) return "D";
        return "F";
    }
}

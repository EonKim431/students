package com.example.students.entity;

import com.example.students.constant.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @Column(name = "student_no",nullable = false,length = 6)
    private String id;
    @Max(100)
    private Integer korean;
    @Max(100)
    private Integer math;
    @Max(100)
    private Integer english;
    @Max(100)
    private Integer history;

}

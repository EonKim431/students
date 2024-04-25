package com.example.students.entity;

import com.example.students.constant.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Students {
    @Id @Column(name = "student_no", nullable = false, length = 6)
    private String id;
    @Column(length = 10)
    private String name;
    @Column(length = 15)
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 20)
    private String address;
}

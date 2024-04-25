package com.example.students.dto;

import com.example.students.constant.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class StudentDto {
    private String id;
    private String name;
    private String phone;
    private Gender gender;
    private String address;
}

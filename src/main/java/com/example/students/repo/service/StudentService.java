package com.example.students.repo.service;

import com.example.students.dto.SearchDto;
import com.example.students.dto.StudentDto;
import com.example.students.repo.StudentsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentsRepo repo;

    public StudentService(StudentsRepo repo) {
        this.repo = repo;
    }

    public List<StudentDto> findAll() {
        List<StudentDto> dtos = repo.findAll().stream()
                .map(x-> StudentDto
                        .builder().id(x.getId()).name(x.getName()).phone(x.getPhone()).gender(x.getGender()).address(x.getAddress())
                        .build())
                .toList();
        return dtos;
    }

    public List<SearchDto> search() {
        List<SearchDto> dtos = SearchDto.mapDataToDTO(repo.searchQuery());
        return dtos;
    }


    public List<String> searchId() {
        return repo.searchId();
    }
}

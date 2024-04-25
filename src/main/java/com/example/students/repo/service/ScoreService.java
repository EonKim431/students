package com.example.students.repo.service;

import com.example.students.dto.ScoreDto;
import com.example.students.entity.Score;
import com.example.students.repo.ScoreRepo;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private final ScoreRepo repo;

    public ScoreService(ScoreRepo repo) {
        this.repo = repo;
    }

    public void save(ScoreDto dto) {
        repo.save(
                Score.builder()
                        .id(dto.getId()).korean(dto.getKorean()).math(dto.getMath()).english(dto.getEnglish()).history(dto.getHistory())
                        .build());
    }
}

package com.example.students.repo;

import com.example.students.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepo extends JpaRepository<Score,String> {
}

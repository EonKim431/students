package com.example.students.constant;

import com.example.students.dto.SearchDto;
import lombok.Data;

import java.util.List;

@Data
public class Cal {
    private int totalMath = 0;
    private int totalKorean = 0;
    private int totalHistory = 0;
    private int totalEnglish = 0;
    private Double totalAvg = 0.0; // 초기값 변경
    private Double tot = 0.0; // 초기값 변경
    private Double avgMath = 0.0; // 실수로 변경
    private Double avgKorean = 0.0; // 실수로 변경
    private Double avgHistory = 0.0; // 실수로 변경
    private Double avgEnglish = 0.0; // 실수로 변경
    private Double avg = 0.0; // 초기값 변경
    private Double avgTotal = 0.0; // 초기값 변경

    public Cal(List<SearchDto> dtos){
        int num = 0;
        for(SearchDto dto : dtos){
            if(dto.getGrade() != null){
                num++;
                totalMath += dto.getMath();
                totalEnglish += dto.getEnglish();
                totalHistory += dto.getHistory();
                totalKorean += dto.getKorean();
                totalAvg += dto.getAvg();
                tot += dto.getTotal();
            }
        }
        avgKorean = totalKorean / (double) num; // 실수 나눗셈으로 변경
        avgMath = totalMath / (double) num; // 실수 나눗셈으로 변경
        avgHistory = totalHistory / (double) num; // 실수 나눗셈으로 변경
        avgEnglish = totalEnglish / (double) num; // 실수 나눗셈으로 변경
        avg = totalAvg / (double) num; // 실수 나눗셈으로 변경
        avgTotal = tot / (double) num; // 실수 나눗셈으로 변경
    }
}
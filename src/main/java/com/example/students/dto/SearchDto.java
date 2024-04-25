package com.example.students.dto;

import com.example.students.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class SearchDto {
    private String student_no;
    private Integer korean;
    private Integer math;
    private Integer english;
    private Integer history;
    private String name;
    private Double avg;
    private Double total;
    private Long grade;

    public static List<SearchDto> mapDataToDTO(List<Object[]> resultList) {
        List<SearchDto> dtoList = new ArrayList<>();
        for (Object[] row : resultList) {
            SearchDto dto = new SearchDto();
            dto.setStudent_no((String) row[0]);
            dto.setName((String) row[1]);
            if(row[2] != null){
                dto.setKorean((Integer) row[2]);
            }
            if(row[3] != null){
                dto.setMath((Integer) row[3]);
            }
            if(row[4] != null){
                dto.setEnglish((Integer) row[4]);
            }
            if(row[5] != null){
                dto.setHistory((Integer) row[5]);
            }
            if(row[6] != null){
                BigDecimal row6 = (BigDecimal) row[6];
                dto.setTotal(row6.doubleValue());
            }
            if(row[7] != null){
                BigDecimal row7 = (BigDecimal) row[7];
                dto.setAvg(row7.doubleValue());
            }
            if(row[7] != null){
                dto.setGrade((Long) row[8]);
            }
            dtoList.add(dto);
        }
        return dtoList;
    }
}

package com.example.students.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {
    String msg1 = "입력해주세요";
    String msg2 = "최대 100점 입니다";
    @NotNull(message = "학번을 입력해주세요")
    private String id;
    @Max(value = 100, message = "최대 100점 입니다")
    @NotNull(message = "국어 점수를 입력해주세요")
    private Integer korean;
    @NotNull(message = "수학 점수를 입력해주세요")
    @Max(value = 100, message = "최대 100점 입니다")
    private Integer math;
    @NotNull(message = "영어 점수를 입력해주세요")
    @Max(value = 100, message = "최대 100점 입니다")
    private Integer english;
    @NotNull(message = "역사 점수를 입력해주세요")
    @Max(value = 100, message = "최대 100점 입니다")
    private Integer history;
}

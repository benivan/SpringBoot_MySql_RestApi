package com.vikash.democollege.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ResultDto {

    private Integer courseId;
    private Double cgpa;
    private String grade;
    private Double marks;

}

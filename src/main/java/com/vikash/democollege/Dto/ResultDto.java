package com.vikash.democollege.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResultDto {

    private String grade;
    private Double marks;
    private Double cgpa;
}

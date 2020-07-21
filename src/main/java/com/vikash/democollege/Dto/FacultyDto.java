package com.vikash.democollege.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FacultyDto {
    private String facultyName;
    private String facultyGender;
    private String facultyCourse;
    private String facultyCabin;
    private String facultyEmail;
    private Long facultyPhone;
}

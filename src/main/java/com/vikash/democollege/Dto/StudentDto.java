package com.vikash.democollege.Dto;

import com.vikash.democollege.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentDto {
    private Long studentEnrollmentNo;
    private String studentName;
    private String studentEmail;
    private Long studentPhoneNumber;
    private String studentAddress;


}

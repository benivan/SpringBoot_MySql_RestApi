package com.vikash.democollege.Response;

import com.vikash.democollege.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OnlyStudentResponse {

    private Integer studentId;

    private Long studentEnrollmentNo;

    private String studentName;

    private String studentEmail;

    private Long studentPhoneNumber;

    private String studentAddress;

    public OnlyStudentResponse(Student student){
        this.studentId = student.getStudentId();
        this.studentEnrollmentNo = student.getStudentEnrollmentNo();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.studentPhoneNumber = student.getStudentPhoneNumber();
        this.studentAddress = student.getStudentAddress();
    }
}

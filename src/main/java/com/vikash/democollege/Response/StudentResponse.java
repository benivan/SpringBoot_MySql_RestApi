package com.vikash.democollege.Response;



import com.vikash.democollege.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StudentResponse {



    private Integer studentId;

    private Long studentEnrollmentNo;

    private String studentName;

    private String studentEmail;

    private Long studentPhoneNumber;

    private String studentAddress;

    private DepartmentResponse department;

    private SectionResponse section;

    private Set<StudentResultResponse> studentResult;

    public StudentResponse(Student student){
        this.studentId = student.getStudentId();
        this.studentEnrollmentNo = student.getStudentEnrollmentNo();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.studentPhoneNumber = student.getStudentPhoneNumber();
        this.studentAddress =student.getStudentAddress();
        this.section = new SectionResponse(student.getSection());
        this.department = new DepartmentResponse(student.getDepartment());
        this.studentResult = student.getStudentResultSet().stream().filter(e -> e.getIsCourseFinished()).map(e-> new StudentResultResponse(e)).collect(Collectors.toSet());
    }

}


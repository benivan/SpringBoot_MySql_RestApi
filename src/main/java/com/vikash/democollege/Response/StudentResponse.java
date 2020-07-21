package com.vikash.democollege.Response;


import com.vikash.democollege.Model.Student;
import com.vikash.democollege.Model.StudentResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StudentResponse {

    private StudentResult studentResult;

    private Integer studentId;

    private Long studentEnrollmentNo;

    private String studentName;

    private String studentEmail;

    private Long studentPhoneNumber;

    private String studentAddress;

    private Set<CourseResponseForStudent> courseSet ;

    private DepartmentResponse department;

    private SectionResponse section;

    public StudentResponse(Student student){
        this.studentId = student.getStudentId();
        this.studentEnrollmentNo = student.getStudentEnrollmentNo();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.studentPhoneNumber = student.getStudentPhoneNumber();
        this.studentAddress =student.getStudentAddress();
        this.section = new SectionResponse(student.getSection());
        this.department = new DepartmentResponse(student.getDepartment());
//        this.courseSet = student.getCourseSet().stream().map( e-> new CourseResponseForStudent(e)).collect(Collectors.toSet());

    }

}


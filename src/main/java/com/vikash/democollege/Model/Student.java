package com.vikash.democollege.Model;

import com.vikash.democollege.Dto.StudentDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
//    @Column(name = "student_id")
    private Integer studentId;
//    @Column(name = "student_enrollment_no")
    private Long studentEnrollmentNo;
//    @Column(name = "student_name")
    private String studentName;
//    @Column(name = "student_email")
    private String studentEmail;
//    @Column(name = "student_phone_number")
    private Long studentPhoneNumber;
//    @Column(name = "student_address")
    private String studentAddress;






    @ManyToOne
    private Department department;

    @ManyToOne
    private Section section;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentResult> studentResultSet = new HashSet<>();


    public Student(StudentDto studentDto) {
        this.studentName = studentDto.getStudentName();
        this.studentEnrollmentNo = studentDto.getStudentEnrollmentNo();
        this.studentEmail = studentDto.getStudentEmail();
        this.studentAddress = studentDto.getStudentAddress();
        this.studentPhoneNumber = studentDto.getStudentPhoneNumber();
    }


}

package com.vikash.democollege.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResult {

    @EmbeddedId
    private StudentResultId studentResultId;

    private Boolean isCourseFinished;
    private String grade;

    private Double marks;

    private Double cgpa;


    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;


}

package com.vikash.democollege.Response;


import com.vikash.democollege.Model.Course;
import com.vikash.democollege.Model.StudentResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentResultResponse {

    private CourseResponseForStudent course;

    private Boolean isCourseFinished;
    private String grade;
    private Double marks;
    private Double cgpa;

    public StudentResultResponse(StudentResult studentResult) {
        this.cgpa = studentResult.getCgpa();
        this.isCourseFinished = studentResult.getIsCourseFinished();
        this.course = new CourseResponseForStudent(studentResult.getCourse());
        this.grade = studentResult.getGrade();
        this.marks = studentResult.getMarks();
    }
}

package com.vikash.democollege.Response;

import com.vikash.democollege.Model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CourseResponseForStudent {
    private Integer courseId;

    private String courseName;


    public CourseResponseForStudent(Course course){
        this.courseId = course.getCourseId();
        this.courseName= course.getCourseName();
    }
}

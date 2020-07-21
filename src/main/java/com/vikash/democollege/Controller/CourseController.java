package com.vikash.democollege.Controller;

import com.vikash.democollege.Dto.CourseDto;
import com.vikash.democollege.Model.Course;
import com.vikash.democollege.Services.CourseService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("college/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addcourse")
    public ResponseEntity<?> addCourse( @RequestBody CourseDto courseDto){
        return courseService.addCourse(new Course(courseDto));
    }
//
//    @PutMapping("/{courseId}/addStudent")
//    public ResponseEntity<?>addStudentToCourse(@PathVariable Integer courseId,@RequestParam Integer studentId){
//        return courseService.addStudentsToCourse(courseId,studentId);
//    }
//
//    @GetMapping("{courseId}/students")
//    public ResponseEntity<?> getAllStudents(@PathVariable Integer courseId){
//        return courseService.getStudents(courseId);
//
//    }

    @PutMapping("/{courseId}/addFaculty")
    public ResponseEntity<?> addFacultyToCourse (@PathVariable Integer courseId, @RequestParam Integer facultyId){
        return courseService.addFacultyToCourse(courseId,facultyId);
    }


    @PutMapping("/{courseId}/addDepartment")
    public ResponseEntity<?> addDepartmentToCorse(@PathVariable Integer courseId, @RequestParam Integer departmenrId){
      return   courseService.addDepartmentToCourse(courseId,departmenrId);
    }



}

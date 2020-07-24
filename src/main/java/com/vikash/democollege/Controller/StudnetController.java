package com.vikash.democollege.Controller;

import com.vikash.democollege.Dto.ResultDto;
import com.vikash.democollege.Dto.StudentDto;
import com.vikash.democollege.Model.Student;
import com.vikash.democollege.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("college/student")
public class StudnetController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public void createStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(new Student(studentDto));
    }

    @PutMapping("/{studentId}/addCourse")
    public ResponseEntity<?> addCourseToStudents(@PathVariable Integer studentId, @RequestParam Integer courseId){
        return studentService.addCourseToStudent(studentId,courseId);
    }

    @PutMapping("/{studentId}/addResult")
    public ResponseEntity<?> addResultToStudent(@PathVariable Integer studentId, @RequestBody ResultDto resultDto){
        return studentService.addResultToStudent(studentId, resultDto);
    }


    @PutMapping("/{studentId}/addDepartment")
    public ResponseEntity<?> addDepartmentToStudents(@PathVariable Integer studentId,@RequestParam Integer departmentId){
        return studentService.addDepartmentToStudent(studentId,departmentId);
    }



    @PutMapping("{studentId}/addSection")
    public ResponseEntity<?> addSectionToStudents(@PathVariable Integer studentId , @RequestParam Long sectionId){
        return studentService.addSectionToStudent(studentId,sectionId);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Integer studentId){
        return studentService.getStudentDetails(studentId);
    }

}

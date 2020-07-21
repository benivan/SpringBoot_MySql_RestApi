package com.vikash.democollege.Services;

import com.vikash.democollege.Dto.CourseDto;
import com.vikash.democollege.Model.*;
import com.vikash.democollege.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {


    private StudentResultRepo studentResultRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private DepartmentRepo departmentRepo;


    public ResponseEntity<?> addCourse(Course course) {
        courseRepo.save(course);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<?> addStudentsToCourse(Integer courseId, Integer studentId) {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            Optional<Student> optionalStudent = studentRepo.findById(studentId);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                if (course.getDepartmentSet().contains(student.getDepartment())) {

                    StudentResult studentResult = StudentResult.builder().
                            studentResultId(new StudentResultId(courseId, studentId))
                            .isCourseFinished(false)
                            .build();
                    studentResultRepo.save(studentResult);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("student Added");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department Diff");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


    public ResponseEntity<?> addFacultyToCourse(Integer courseId, Integer facultyId) {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            Optional<Faculty> optionalFaculty = facultyRepo.findById(facultyId);
            if (optionalFaculty.isPresent()) {
                Faculty faculty = optionalFaculty.get();
                course.getFacultiesSet().add(faculty);
                faculty.getCourseSet().add(course);
                courseRepo.save(course);
                facultyRepo.save(faculty);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("faculty added");

            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


//    public ResponseEntity<?> getStudents(Integer courseId) {
//        Optional<Course> optionalCourse = courseRepo.findById(courseId);
//       if (optionalCourse.isPresent()){
//           Course course = optionalCourse.get();
//
//           List<String> studentNames = course.getStudentSet().stream().map(e -> e.getStudentName()).collect(Collectors.toList());
//           return ResponseEntity.ok(studentNames);
//       }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }


    public ResponseEntity<?> addDepartmentToCourse(Integer courseId, Integer departmenrId) {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            Optional<Department> optionalDepartment = departmentRepo.findById(departmenrId);
            if (optionalDepartment.isPresent()) {
                Department department = optionalDepartment.get();
                department.getCourseSet().add(course);
                course.getDepartmentSet().add(department);
                courseRepo.save(course);
                departmentRepo.save(department);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Department Added");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}

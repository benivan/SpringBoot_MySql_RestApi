package com.vikash.democollege.Services;

import com.vikash.democollege.Dto.ResultDto;
import com.vikash.democollege.Model.*;
import com.vikash.democollege.Repository.*;
import com.vikash.democollege.Response.StudentResponse;
import com.vikash.democollege.Response.StudentResultResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {


    final StudentRepo studentRepo;

    final CourseRepo courseRepo;

    final StudentResultRepo studentResultRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private SectionRepo sectionRepo;


    public void saveStudent(Student student) {

        studentRepo.save(student);
    }

    public ResponseEntity<?> addCourseToStudent(Integer studentId, Integer courseId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Optional<Course> optionalCourse = courseRepo.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                if (course.getDepartmentSet().contains(student.getDepartment())) {

                    StudentResult studentResult = StudentResult.builder()
                            .studentResultId(new StudentResultId(courseId,studentId))
                            .isCourseFinished(false)
                            .build();
                    studentResultRepo.save(studentResult);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Course Added");
                }
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Students Department Diff");
            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }


    public ResponseEntity<?> addDepartmentToStudent(Integer studentId, Integer departmentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println(student);
            Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
            if (optionalDepartment.isPresent()) {
                Department department = optionalDepartment.get();
                student.setDepartment(department);
                department.getStudentSet().add(student);
                studentRepo.save(student);
                departmentRepo.save(department);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Department Added");

            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }


    public ResponseEntity<?> addSectionToStudent(Integer studentId, Long sectionId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Optional<Section> optionalSection = sectionRepo.findById(sectionId);
            if (optionalSection.isPresent()) {
                Section section = optionalSection.get();
                if (section.getDepartment().equals(student.getDepartment())) {
                    student.setSection(section);
                    section.getStudentSet().add(student);
                    studentRepo.save(student);
                    sectionRepo.save(section);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Section Added");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department don't have this section");

            } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }




    public ResponseEntity<?> getStudentDetails(Integer studentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
           Student student = optionalStudent.get();
            return ResponseEntity.ok(new StudentResponse(student));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
    }




    public ResponseEntity<?> addResultToStudent(Integer studentId, ResultDto resultDto) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Optional<Course> optionalCourse = courseRepo.findById(resultDto.getCourseId());
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                if (course.getDepartmentSet().contains(student.getDepartment())) {
                    StudentResult studentResult = StudentResult.builder()
                            .studentResultId(new StudentResultId(course.getCourseId(),student.getStudentId()))
                            .student(student)
                            .cgpa(resultDto.getCgpa())
                            .isCourseFinished(resultDto.getMarks() >= 50)
                            .course(course)
                            .grade(resultDto.getGrade())
                            .marks(resultDto.getMarks())
                            .build();
                    studentResultRepo.save(studentResult);
                    return ResponseEntity.status(HttpStatus.CREATED).build();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student ans Course are not in same Department");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

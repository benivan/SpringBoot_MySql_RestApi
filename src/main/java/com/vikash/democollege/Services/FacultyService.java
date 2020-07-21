package com.vikash.democollege.Services;

import com.vikash.democollege.Dto.FacultyDto;
import com.vikash.democollege.Model.Course;
import com.vikash.democollege.Model.Department;
import com.vikash.democollege.Model.Faculty;
import com.vikash.democollege.Model.Student;
import com.vikash.democollege.Repository.CourseRepo;
import com.vikash.democollege.Repository.DepartmentRepo;
import com.vikash.democollege.Repository.FacultyRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultyService {


    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private CourseRepo courseRepo;

    public ResponseEntity<?> saveFaculty(Faculty faculty) {
        facultyRepo.save(faculty);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<?> addDepartmentToFaculty(Integer facultyId, Integer departmentId) {
        Optional<Faculty> optionalFaculty = facultyRepo.findById(facultyId);
        if (optionalFaculty.isPresent()) {
            Faculty faculty = optionalFaculty.get();
            Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
            if (optionalDepartment.isPresent()) {
                Department department = optionalDepartment.get();
                department.getFacultySet().add(faculty);
                faculty.setDepartment(department);
                facultyRepo.save(faculty);
                departmentRepo.save(department);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("department Added");
            }
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    public ResponseEntity<?> addCoursesToFaculty(Integer facultyId, Integer cpurseId) {
        Optional<Faculty> optionalFaculty = facultyRepo.findById(facultyId);
        if (optionalFaculty.isPresent()) {
            Faculty faculty =optionalFaculty.get();
            Optional<Course> optionalCourse = courseRepo.findById(cpurseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getFacultiesSet().add(faculty);
                faculty.getCourseSet().add(course);
                facultyRepo.save(faculty);
                courseRepo.save(course);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("course Added");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

}

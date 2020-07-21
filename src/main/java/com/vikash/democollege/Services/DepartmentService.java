package com.vikash.democollege.Services;

import com.vikash.democollege.Model.Course;
import com.vikash.democollege.Model.Department;
import com.vikash.democollege.Model.Section;
import com.vikash.democollege.Repository.CourseRepo;
import com.vikash.democollege.Repository.DepartmentRepo;
import com.vikash.democollege.Repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

@Autowired
private DepartmentRepo departmentRepo;
@Autowired
private CourseRepo courseRepo;
@Autowired
private SectionRepo sectionRepo;

    public ResponseEntity<?> saveDepartment(Department department) {
        departmentRepo.save(department);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<?> addCourseToDepartment(Integer departmentId, Integer courseId) {
        Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            Optional<Course> optionalCourse = courseRepo.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getDepartmentSet().add(department);
                department.getCourseSet().add(course);
                departmentRepo.save(department);
                courseRepo.save(course);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Course Added");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    public ResponseEntity<?> addSectionToDepartment(Integer departmentId, Long sectionId) {

        Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            Optional<Section> optionalSection = sectionRepo.findById(sectionId);
            if (optionalSection.isPresent()) {
                Section section = optionalSection.get();
                department.getSectionSet().add(section);
                section.setDepartment(department);
                sectionRepo.save(section);
                departmentRepo.save(department);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("section Added");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

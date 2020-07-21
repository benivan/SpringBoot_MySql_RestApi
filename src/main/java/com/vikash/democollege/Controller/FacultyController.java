package com.vikash.democollege.Controller;

import com.vikash.democollege.Dto.FacultyDto;
import com.vikash.democollege.Model.Faculty;
import com.vikash.democollege.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("college/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/addFaculty")
    public ResponseEntity<?> addFaculty(@RequestBody  FacultyDto facultyDto){
        return facultyService.saveFaculty(new Faculty(facultyDto));
    }

    @PutMapping("/{facultyId}/addDepartment")
    public ResponseEntity<?> addDepartmentToFaculty(@PathVariable Integer facultyId, @RequestParam  Integer departmentId){
       return facultyService.addDepartmentToFaculty(facultyId,departmentId);
    }

    @PutMapping("{facultyId}/addCourse")
    public ResponseEntity<?> addCoursesToFaculty(@PathVariable Integer facultyId, @RequestParam Integer courseId){
        return facultyService.addCoursesToFaculty(facultyId, courseId);
    }



}

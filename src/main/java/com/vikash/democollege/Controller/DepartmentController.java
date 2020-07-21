package com.vikash.democollege.Controller;

import com.vikash.democollege.Dto.DepartmentDto;
import com.vikash.democollege.Model.Department;
import com.vikash.democollege.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("college/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<?> addDepartment (@RequestBody DepartmentDto departmentDto){
      return departmentService.saveDepartment(new Department(departmentDto));

    }

    @PutMapping("/{departmentId}/addCourse")
    public ResponseEntity<?> addCourseToDepartment(@PathVariable Integer departmentId, @RequestParam Integer courseId){
        return departmentService.addCourseToDepartment(departmentId,courseId);
    }

    @PutMapping("/{departmentId}/addSection")
    public ResponseEntity<?> addSectionToDepartment(@PathVariable Integer departmentId, @RequestParam Long sectionId){
        return departmentService.addSectionToDepartment(departmentId,sectionId);
    }



}

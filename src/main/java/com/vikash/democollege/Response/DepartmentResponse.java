package com.vikash.democollege.Response;

import com.vikash.democollege.Model.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DepartmentResponse {
    private Integer departmentId;

    private String departmentName;

    private String departmentHead;

    public DepartmentResponse(Department department){
        this.departmentId = department.getDepartmentId();
        this.departmentName = department.getDepartmentName();
        this.departmentHead =department.getDepartmentHead();
    }
}

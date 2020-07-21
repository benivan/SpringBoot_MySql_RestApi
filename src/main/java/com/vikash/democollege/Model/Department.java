package com.vikash.democollege.Model;


import com.vikash.democollege.Dto.DepartmentDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "department_id")
    private Integer departmentId;
//    @Column(name = "department_name")
    private String departmentName;
//    @Column(name = "department_head")
    private String departmentHead;

    @OneToMany(mappedBy = "department")
    private Set<Faculty> facultySet = new HashSet<>();

    @ManyToMany(mappedBy = "departmentSet")
    private Set<Course> courseSet = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Student> studentSet = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Section> sectionSet = new HashSet<>();


    public Department(DepartmentDto departmentDto) {
        this.departmentName = departmentDto.getDepartmentName();
        this.departmentHead = departmentDto.getDepartmentHead();
    }


}
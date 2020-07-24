package com.vikash.democollege.Model;

import com.vikash.democollege.Dto.CourseDto;
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
public class Course {
    @Id
    @GeneratedValue
    private Integer courseId;
    private String courseName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(joinColumns = {@JoinColumn()},
    inverseJoinColumns = {@JoinColumn()})
    private Set<Department> departmentSet = new HashSet<>();


    @ManyToMany(mappedBy = "courseSet")
    private Set<Faculty> facultiesSet = new HashSet<>() ;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<StudentResult> studentResultSet = new HashSet<>();


    public Course(CourseDto courseDto){
        this.courseName = courseDto.getCourseName();
    }

}

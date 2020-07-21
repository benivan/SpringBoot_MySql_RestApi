package com.vikash.democollege.Model;

import com.vikash.democollege.Dto.FacultyDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "faculty_id")
    private Integer facultyId;
//    @Column(name = "faculty_id")
    private String facultyGender;
//    @Column(name = "faculty_name")
    private String facultyName;
//    @Column(name = "faculty_course")
    private String facultyCourse;
//    @Column(name = "faculty_cabin")
    private String facultyCabin;
//    @Column(name = "faculty_email")
    private String facultyEmail;
//    @Column(name = "faculty_phone")
    private Long facultyPhone;

    @ManyToOne
    private Department department;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn()},

            inverseJoinColumns = {@JoinColumn()}
    )
    private Set<Course> courseSet = new HashSet<>();



    @OneToMany(mappedBy = "sectionLead")
    private Set<Section> sectionSet = new HashSet<>();


    public Faculty(FacultyDto facultyDto) {
        this.facultyGender = facultyDto.getFacultyGender();
        this.facultyName = facultyDto.getFacultyName();
        this.facultyCourse = facultyDto.getFacultyCourse();
        this.facultyCabin = facultyDto.getFacultyCabin();
        this.facultyEmail = facultyDto.getFacultyEmail();
        this.facultyPhone = facultyDto.getFacultyPhone();
    }




}

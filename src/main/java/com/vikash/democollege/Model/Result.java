package com.vikash.democollege.Model;

import com.vikash.democollege.Dto.ResultDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Result {
    @Id @GeneratedValue

    private Long resultId;

    private String grade;

    private Double marks;

    private Double cgpa;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;



    public Result(ResultDto resultDto){
        this.grade = resultDto.getGrade();
        this.cgpa = resultDto.getCgpa();
        this.marks = resultDto.getMarks();



    }
}

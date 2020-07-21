package com.vikash.democollege.Model;


import com.vikash.democollege.Dto.SectionDto;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

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
public class Section {

    @Id @GeneratedValue
//    @Column(name = "section_id")
    private Long sectionId;
//    @Column(name = "section_name")
    private Integer sectionName;


    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "section")
    private Set<Student> studentSet = new HashSet<>();

    @ManyToOne
    private Faculty sectionLead;

    public Section(SectionDto sectionDto) {
        this.sectionName = sectionDto.getSectionName();
    }
}

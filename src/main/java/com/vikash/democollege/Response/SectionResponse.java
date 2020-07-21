package com.vikash.democollege.Response;

import com.vikash.democollege.Model.Section;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SectionResponse {
    private Long sectionId;

    private Integer sectionName;

    public SectionResponse(Section section){
        this.sectionId = section.getSectionId();
        this.sectionName = section.getSectionName();
    }
}

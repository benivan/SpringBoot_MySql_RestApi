package com.vikash.democollege.Controller;

import com.vikash.democollege.Dto.SectionDto;
import com.vikash.democollege.Model.Section;
import com.vikash.democollege.Services.SectionSecvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("college/section")
public class SectionController {

    @Autowired
    private SectionSecvice sectionSecvice;

    @PostMapping("/addSection")
   public ResponseEntity<?> addSection(@RequestBody SectionDto sectionDto){
      return sectionSecvice.saveSection(new Section(sectionDto));
   }


   @PutMapping("{sectionId}/addSectionLead")
    public ResponseEntity<?> addSectionLead(@PathVariable Long sectionId, @RequestParam Integer facultyId){
      return   sectionSecvice.addSectionLead(sectionId,facultyId);
   }


}

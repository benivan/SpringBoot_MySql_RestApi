package com.vikash.democollege.Services;

import com.vikash.democollege.Model.Faculty;
import com.vikash.democollege.Model.Section;
import com.vikash.democollege.Repository.FacultyRepo;
import com.vikash.democollege.Repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionSecvice {

    @Autowired
    private SectionRepo sectionRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    public ResponseEntity<?> saveSection(Section section) {
        sectionRepo.save(section);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<?> addSectionLead(Long sectionId, Integer facultyId) {
        Optional<Section> optionalSection = sectionRepo.findById(sectionId);
        if (optionalSection.isPresent()) {
            Section section = optionalSection.get();
            Optional<Faculty> optionalFaculty = facultyRepo.findById(facultyId);
            if (optionalFaculty.isPresent()) {
                Faculty faculty = optionalFaculty.get();
                if (faculty.getDepartment().equals(section.getDepartment())) {
                    faculty.getSectionSet().add(section);
                    section.setSectionLead(faculty);
                    facultyRepo.save(faculty);
                    sectionRepo.save(section);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("SectionLead Added");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty don't belong to this department");

            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

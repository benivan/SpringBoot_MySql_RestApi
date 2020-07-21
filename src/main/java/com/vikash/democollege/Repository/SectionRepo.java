package com.vikash.democollege.Repository;

import com.vikash.democollege.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section,Long> {
}

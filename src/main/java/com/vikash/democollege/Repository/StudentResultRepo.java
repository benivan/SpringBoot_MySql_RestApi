package com.vikash.democollege.Repository;

import com.vikash.democollege.Model.StudentResult;
import com.vikash.democollege.Model.StudentResultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultRepo extends JpaRepository<StudentResult, StudentResultId> {
}

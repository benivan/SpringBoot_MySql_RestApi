package com.vikash.democollege.Repository;

import com.vikash.democollege.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo  extends JpaRepository<Student,Integer> {
}

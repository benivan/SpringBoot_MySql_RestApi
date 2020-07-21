package com.vikash.democollege.Repository;

import com.vikash.democollege.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result,Long> {
}

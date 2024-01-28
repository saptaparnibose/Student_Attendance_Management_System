package com.xfactor.openlibrary.Repositries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    
}

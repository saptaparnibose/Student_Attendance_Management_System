package com.xfactor.openlibrary.Repositries;


import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Subject;
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}

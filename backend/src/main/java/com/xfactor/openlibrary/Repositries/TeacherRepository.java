package com.xfactor.openlibrary.Repositries;



import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Teacher;
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
package com.xfactor.openlibrary.Repositries;



import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Attendance;
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
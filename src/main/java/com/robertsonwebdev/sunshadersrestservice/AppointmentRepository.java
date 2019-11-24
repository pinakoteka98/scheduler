package com.robertsonwebdev.sunshadersrestservice;

import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAllByAppointmentDate(Date date);
}

package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.sunshadersrestservice.Appointment;
import com.robertsonwebdev.sunshadersrestservice.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path = "/services")
public class ServicesController {

    private final AppointmentRepository appointmentRepository;


    @Autowired
    public ServicesController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewAppointment(@ModelAttribute Appointment appointment){
        try {
            appointmentRepository.save(appointment);
            return "Appointment was added succesfully";

        } catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();

        for(Appointment appt : appointmentRepository.findAll()){
            appointments.add(appt);
        }
        // Sort the List by date and then by time
        appointments = sortAppointments(appointments);
        return appointments;
    }

    @GetMapping(path = "/all/{date}")
    public @ResponseBody List<Appointment> getAppointmentsByDate(@PathVariable String date){
        try{
            Date sqlDate = Date.valueOf(date);
            List<Appointment> appointments = appointmentRepository.findAllByAppointmentDate(sqlDate);


            appointments = sortAppointments(appointments);

            return appointments;
        } catch (Exception ex){
            Appointment appt = new Appointment();
            List<Appointment> appointments = new ArrayList<>();
            appointments.add(appt);
            return appointments;
        }

    }

    private List<Appointment> sortAppointments(List<Appointment> appointments){
         appointments.sort(Comparator.comparing(Appointment::getAppointmentDate)
                    .thenComparing(Appointment::getAppointmentTime));
         return appointments;

    }
}

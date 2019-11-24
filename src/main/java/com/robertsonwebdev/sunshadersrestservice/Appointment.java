package com.robertsonwebdev.sunshadersrestservice;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private Date appointmentDate;
    private Time appointmentTime;

    public Appointment(){}

    public Appointment(String firstname, String lastname, Date appointmentDate, Time appointmentTime){
        this.firstname = firstname;
        this.lastname = lastname;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = Date.valueOf(appointmentDate);
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = Time.valueOf(appointmentTime);
    }
}

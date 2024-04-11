package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
}

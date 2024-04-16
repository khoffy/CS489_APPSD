package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.AppointmentDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addAppointment(AppointmentDto appointmentDto);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
}

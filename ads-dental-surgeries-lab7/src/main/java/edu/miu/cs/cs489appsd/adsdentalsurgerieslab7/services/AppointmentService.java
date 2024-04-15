package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AppointmentDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addAppointment(AppointmentDto appointmentDto);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
}

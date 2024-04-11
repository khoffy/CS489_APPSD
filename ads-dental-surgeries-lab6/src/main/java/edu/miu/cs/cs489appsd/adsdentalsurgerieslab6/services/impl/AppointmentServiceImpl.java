package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Appointment;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


}

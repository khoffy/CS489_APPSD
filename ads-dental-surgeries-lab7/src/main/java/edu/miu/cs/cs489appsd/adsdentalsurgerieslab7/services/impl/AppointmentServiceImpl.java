package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AppointmentDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Appointment;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(AppointmentDto appointmentDto) {
        Address address = new Address(appointmentDto.patientDto().addressDto().id(),
                appointmentDto.patientDto().addressDto().street(),
                appointmentDto.patientDto().addressDto().city(),
                appointmentDto.patientDto().addressDto().state(),
                appointmentDto.patientDto().addressDto().zip());
        Appointment appointment = getAppointment(appointmentDto, address);

        return appointmentRepository.save(appointment);
    }

    private static Appointment getAppointment(AppointmentDto appointmentDto, Address address) {
        Patient patient = new Patient(appointmentDto.patientDto().id(), appointmentDto.patientDto().firstName(),
                appointmentDto.patientDto().lastName(), appointmentDto.patientDto().email(),
                appointmentDto.patientDto().phoneNumber(), appointmentDto.patientDto().dateOfBirth(),
                address);


        Appointment appointment = new Appointment(appointmentDto.id(), patient, appointmentDto.dentist(), 
                appointmentDto.surgery(), appointmentDto.date());
        return appointment;
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

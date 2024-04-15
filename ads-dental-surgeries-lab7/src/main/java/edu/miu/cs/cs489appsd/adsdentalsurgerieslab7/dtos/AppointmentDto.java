package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Dentist;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Surgery;

import java.time.LocalDate;

public record AppointmentDto(String id, PatientDto patientDto, Dentist dentist, Surgery surgery, LocalDate date) {
}

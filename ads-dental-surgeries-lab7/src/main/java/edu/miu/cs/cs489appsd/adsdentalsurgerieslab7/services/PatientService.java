package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<PatientDto> getAllPatients();
    PatientDto getPatientById(String id);
}

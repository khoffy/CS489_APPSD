package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    PatientDto updatePatient(String patientId, PatientDto patientdto);
    void deletePatient(String patientId);
    List<PatientDto> getAllPatients();
    PatientDto getPatientById(String id);
}

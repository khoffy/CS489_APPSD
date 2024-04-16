package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    PatientDto updatePatient(String patientId, PatientDto patientdto);
    void deletePatient(String patientId);
    List<PatientDto> getAllPatients();
    List<PatientDto> searchPatient(String search);
    PatientDto getPatientById(String id);
}

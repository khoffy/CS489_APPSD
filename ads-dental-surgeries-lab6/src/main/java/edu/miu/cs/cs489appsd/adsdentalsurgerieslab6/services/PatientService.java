package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getAllPatients();
}

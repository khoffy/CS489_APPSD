package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories.PatientRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}

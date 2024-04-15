package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories.PatientRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Address address = Address.builder()
                .street(patientDto.addressDto().street())
                .city(patientDto.addressDto().city())
                .state(patientDto.addressDto().state())
                .zip(patientDto.addressDto().zip())
                .build();
        Patient patient = new Patient(patientDto.id(), patientDto.firstName(), patientDto.lastName(), 
                patientDto.email(), patientDto.phoneNumber(), patientDto.dateOfBirth(), address);
        
        Patient createdPatient = patientRepository.save(patient);
        AddressDto addressDto = new AddressDto(createdPatient.getAddress().getId(), 
                createdPatient.getAddress().getStreet(), createdPatient.getAddress().getCity(),
                createdPatient.getAddress().getState(), createdPatient.getAddress().getZip());

        return new PatientDto(createdPatient.getId(), createdPatient.getFirstName(), createdPatient.getLastName(),
                createdPatient.getEmail(), createdPatient.getPhoneNumber(), createdPatient.getDateOfBirth(), addressDto);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {

        return patientRepository.findAll().stream()
                .map(patient -> {
                    AddressDto addressDto = new AddressDto(patient.getAddress().getId(), patient.getAddress().getStreet(),
                            patient.getAddress().getCity(), patient.getAddress().getState(), patient.getAddress().getZip());
                    return new PatientDto(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getEmail(),
                            patient.getPhoneNumber(), patient.getDateOfBirth(), addressDto);
                }).toList();
    }

    @Override
    public PatientDto getPatientById(String id) {
        return patientRepository.findById(id).map(patient -> {
            AddressDto addressDto = new AddressDto(patient.getAddress().getId(), patient.getAddress().getStreet(),
                    patient.getAddress().getCity(), patient.getAddress().getState(), patient.getAddress().getZip());
            return new PatientDto(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getEmail(),
                    patient.getPhoneNumber(), patient.getDateOfBirth(), addressDto);
        }).orElse(new PatientDto(null, null, null, null, null, null, null));
    }


}

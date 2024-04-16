package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.exceptions.PatientNotFoundException;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories.PatientRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Address address = Address.builder()
                .id(patientDto.addressDto().id())
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
    public PatientDto updatePatient(String patientId, PatientDto patientDto) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if(Objects.isNull(patient)) {
            throw new PatientNotFoundException("Id not found");
        }
        Address address = Address.builder()
                .id(patientDto.addressDto().id())
                .street(patientDto.addressDto().street())
                .city(patientDto.addressDto().city())
                .state(patientDto.addressDto().state())
                .zip(patientDto.addressDto().zip())
                .build();
        patient.setId(patientId);
        patient.setFirstName(patientDto.firstName());
        patient.setLastName(patientDto.lastName());
        patient.setEmail(patientDto.email());
        patient.setPhoneNumber(patientDto.phoneNumber());
        patient.setDateOfBirth(patientDto.dateOfBirth());
        patient.setAddress(address);
        Patient updatedPatient = patientRepository.saveAndFlush(patient);

        AddressDto addressDto = new AddressDto(updatedPatient.getAddress().getId(),
                updatedPatient.getAddress().getStreet(), updatedPatient.getAddress().getCity(),
                updatedPatient.getAddress().getState(), updatedPatient.getAddress().getZip());

        return new PatientDto(updatedPatient.getId(), updatedPatient.getFirstName(), updatedPatient.getLastName(),
                updatedPatient.getEmail(), updatedPatient.getPhoneNumber(), updatedPatient.getDateOfBirth(), addressDto);
    }

    @Override
    public void deletePatient(String patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (Objects.nonNull(patient)) {
            patientRepository.delete(patient);
        }
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
    public List<PatientDto> searchPatient(String search) {

        return List.of();
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

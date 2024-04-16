package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Dentist;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories.DentistRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository  = dentistRepository;
    }

    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist updateDentist(Long dentistId, Dentist dentistDto) {
        Dentist dentist = dentistRepository.findById(dentistId).orElse(null);
        if (Objects.nonNull(dentist)) {
            dentist.setEmail(dentistDto.getEmail());
            dentist.setFirstName(dentistDto.getFirstName());
            dentist.setLastName(dentistDto.getLastName());
            dentist.setSpecialization(dentistDto.getSpecialization());
        }
        assert dentist != null;
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long dentistId) {
        dentistRepository.deleteById(dentistId);
    }
}

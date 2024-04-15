package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Dentist;

import java.util.List;

public interface DentistService {
    Dentist createDentist(Dentist dentist);
    List<Dentist> getAllDentists();
    Dentist updateDentist(Long dentistId, Dentist dentistDTO);
    void deleteDentist(Long dentistId);
}

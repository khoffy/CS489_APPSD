package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Dentist;

import java.util.List;

public interface DentistService {
    Dentist createDentist(Dentist dentist);
    List<Dentist> getAllDentists();
    Dentist updateDentist(Long dentistId, Dentist dentistDTO);
    void deleteDentist(Long dentistId);
}

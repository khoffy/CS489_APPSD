package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery createSurgery(Surgery surgery);
    List<Surgery> getAllSurgery();
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgery(Surgery surgery);
}

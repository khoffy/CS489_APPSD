package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery createSurgery(Surgery surgery);
    List<Surgery> getAllSurgery();
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgery(Surgery surgery);
}

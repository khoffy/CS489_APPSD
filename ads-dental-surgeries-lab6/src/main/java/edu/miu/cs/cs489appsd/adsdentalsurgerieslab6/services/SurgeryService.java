package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery createSurgery(Surgery surgery);
    List<Surgery> getAllSurgery();
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;

public record PatientDto(String id, String firstName, String lastName, String email, String phoneNumber,
                         String dateOfBirth, AddressDto addressDto) {
}

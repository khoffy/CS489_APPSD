package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record PatientDto(
        @NotBlank(message = "Provide ID")
        String id,
        @NotBlank(message = "Provide First name")
        String firstName,
        @NotBlank(message = "Provide Last name")
        String lastName,
        @Email(message = "Provide a valid email address")
        String email,
        String phoneNumber,
        String dateOfBirth,
        AddressDto addressDto) {
}

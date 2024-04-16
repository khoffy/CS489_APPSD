package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


public record PatientDto(
        @NotBlank(message = "Provide ID")
        String id,
        @NotBlank(message = "Provide First name")
        String firstName,
        @NotEmpty
        @NotBlank(message = "Provide Last name")
        String lastName,
        @NotEmpty
        @Email(message = "Provide a valid email address")
        String email,
        String phoneNumber,
        String dateOfBirth,
        AddressDto addressDto) {
}

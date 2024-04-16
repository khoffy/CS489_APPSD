package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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

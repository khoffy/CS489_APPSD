package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Patient extends AppUser {


    private String dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Appointment> appointments;

    public Patient() {}

    public Patient(String id, String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, Address address) {
        super(id, firstName, lastName, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.appointments = new ArrayList<>();
    }



    @Override
    public String toString() {
        return "Patient{" +
                super.toString() +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }
}

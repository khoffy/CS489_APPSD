package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities;

import jakarta.persistence.*;
import lombok.Builder;
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


//    public String getId() {
//        return super.getId();
//    }
//
//    public void setId(String id) {
//        super.setId(id);
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    @Override
//    public String getFirstName() {
//        return super.getFirstName();
//    }
//
//    @Override
//    public String getLastName() {
//        return super.getLastName();
//    }
//
//    @Override
//    public void setEmail(String email) {
//        super.setEmail(email);
//    }
//
//    @Override
//    public String getPhoneNumber() {
//        return super.getPhoneNumber();
//    }
//
//    @Override
//    public void setFirstName(String firstName) {
//        super.setFirstName(firstName);
//    }
//
//    public void setLastName(String lastName) {
//        super.setLastName(lastName);
//    }
//
//    @Override
//    public String getEmail() {
//        return super.getEmail();
//    }
//
//    @Override
//    public void setPhoneNumber(String phoneNumber) {
//        super.setPhoneNumber(phoneNumber);
//    }
//
//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }

    @Override
    public String toString() {
        return "Patient{" +
                super.toString() +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }
}

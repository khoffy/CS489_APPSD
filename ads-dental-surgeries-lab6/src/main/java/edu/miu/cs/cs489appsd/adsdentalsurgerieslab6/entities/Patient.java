package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities;

import jakarta.persistence.*;

@Entity
public class Patient extends User {

    @Id
    private String id;

    private String dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    public Patient() {}

    public Patient(String id, String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, Address address) {
        super(firstName, lastName, email, phoneNumber);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Patient(String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, Address address) {
        super(firstName, lastName, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", " + super.toString() +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }
}

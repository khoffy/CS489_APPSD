package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Dentist extends User {

    @Id
    private String id;

    private String specialization;

    @OneToMany
    private List<Appointment> appointments;

    public Dentist() {}

    public Dentist(String id, String firstname, String lastname, String email, String phoneNumber, String specialization) {
        super(firstname, lastname, email, phoneNumber);
        this.id = id;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id='" + id + '\'' +
                super.toString() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}

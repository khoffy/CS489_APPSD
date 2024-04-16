package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Dentist extends AppUser {


    private String specialization;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public Dentist() {}

    public Dentist(String id, String firstname, String lastname, String email, String phoneNumber, String specialization) {
        super(id, firstname, lastname, email, phoneNumber);
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
        super.setId(id);
    }

    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Dentist{" +
                super.toString() +
                "specialization='" + specialization + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    private String id;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Dentist dentist;

    @OneToOne
    private Surgery surgery;

    private LocalDate date;

    public Appointment() {}

    public Appointment(String id, Patient patient, Dentist dentist, Surgery surgery, LocalDate date ) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
        this.date = date;
    }

    public Appointment(Patient patient, Dentist dentist, Surgery surgery, LocalDate date ) {
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", surgery=" + surgery +
                ", date=" + date +
                '}';
    }
}

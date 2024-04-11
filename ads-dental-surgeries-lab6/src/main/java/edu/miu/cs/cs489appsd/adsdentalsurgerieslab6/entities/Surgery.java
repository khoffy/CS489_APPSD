package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Surgery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Appointment> appointments;

    public Surgery() {}

    public Surgery(long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.appointments = new ArrayList<>();
    }
}

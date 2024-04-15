package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfficeManager extends AppUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}

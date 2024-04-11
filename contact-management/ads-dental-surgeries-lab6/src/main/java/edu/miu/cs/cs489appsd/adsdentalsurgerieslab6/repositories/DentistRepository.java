package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Patient, Long> {
}

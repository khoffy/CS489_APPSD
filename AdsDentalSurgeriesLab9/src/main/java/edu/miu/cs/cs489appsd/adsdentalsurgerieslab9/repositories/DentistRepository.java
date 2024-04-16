package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}

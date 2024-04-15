package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}

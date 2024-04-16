package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}

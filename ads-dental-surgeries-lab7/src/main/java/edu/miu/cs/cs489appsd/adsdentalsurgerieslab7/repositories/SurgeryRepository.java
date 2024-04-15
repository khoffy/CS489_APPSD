package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}

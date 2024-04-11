package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Address, Long> {
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

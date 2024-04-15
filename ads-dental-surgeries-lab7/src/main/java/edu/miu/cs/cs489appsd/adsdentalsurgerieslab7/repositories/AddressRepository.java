package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

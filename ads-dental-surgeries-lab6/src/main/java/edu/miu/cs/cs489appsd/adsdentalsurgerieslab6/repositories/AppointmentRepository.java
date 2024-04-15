package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
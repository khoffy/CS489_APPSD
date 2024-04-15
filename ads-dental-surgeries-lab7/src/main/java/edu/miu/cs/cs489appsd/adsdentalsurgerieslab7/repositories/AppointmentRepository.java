package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.repositories;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

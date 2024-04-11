package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.PatientService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdsDentalSurgeriesLab6Application implements CommandLineRunner {

    @Autowired
    private PatientServiceImpl patientService;

    public static void main(String[] args) {
        SpringApplication.run(AdsDentalSurgeriesLab6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address gillianWhiteAddr = new Address("A100", "1000 North 4th Stret", "Fairfield", "IA");
        Patient gillianWhiteDto = new Patient("P100", "Gillian", "White", "gillian.white@gmail.com",
                "641-555-8765", "555-233-8888", gillianWhiteAddr);
        Patient gillianWhite =  patientService.addPatient(gillianWhiteDto);



        System.out.println(patientService.getAllPatients());
    }

}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.*;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.AppointmentService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.DentistService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.PatientService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl.DentistServiceImpl;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl.PatientServiceImpl;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl.SurgeryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class AdsDentalSurgeriesLab6Application implements CommandLineRunner {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DentistService dentistService;

    @Autowired
    private SurgeryServiceImpl surgeryService;

    @Autowired
    private AppointmentService appointmentService;


    public static void main(String[] args) {
        SpringApplication.run(AdsDentalSurgeriesLab6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address gillianWhiteAddr = new Address("A100", "1000 North 4th Stret", "Fairfield", "IA");
        Patient gillianWhiteDto = new Patient("P100", "Gillian", "White", "gillian.white@gmail.com",
                "641-555-8765", "555-233-8888", gillianWhiteAddr);
        Patient gillianWhite =  patientService.addPatient(gillianWhiteDto);

        Address jillBellAddr = new Address("A101", "1000 North 4th Stret", "Fairfield", "IA");
        Patient jillBellDto = new Patient("P101", "jill", "Bell", "jill.bell@gmail.com",
                "641-555-8765", "555-233-8888", jillBellAddr);
        Patient jillBell =  patientService.addPatient(jillBellDto);

        Address ianMacKayAddr = new Address("A102", "1000 North 4th Stret", "Fairfield", "IA");
        Patient ianMacKayDto = new Patient("P102", "Ian", "MacKay", "ian.macKay@gmail.com",
                "641-555-8765", "555-233-8888", ianMacKayAddr);
        Patient ianMacKay =  patientService.addPatient(ianMacKayDto);

        Address johnWalkerAddr = new Address("A103", "1000 North 4th Stret", "Fairfield", "IA");
        Patient johnWalkerDto = new Patient("P103", "John", "Walker", "john.walker@gmail.com",
                "641-555-8765", "555-233-8888", johnWalkerAddr);
        Patient johnWalker =  patientService.addPatient(johnWalkerDto);


        Address tonySmithAddr = new Address("A104", "1000 North 4th Stret", "Fairfield", "IA");
        Address helenPearsonAddr = new Address("A105", "1000 North 4th Stret", "Fairfield", "IA");
        Address robinPlevinAddr = new Address("A106", "1000 North 4th Stret", "Fairfield", "IA");

        Dentist tonySmithDto = new Dentist("D100", "Tony", "Smith", "tony.smith@gmail.com",
                "765-887-78434", "Specialization1");
        Dentist helenPearsonDto = new Dentist("D101", "Helen", "Pearson", "helen.pearson@gmail.com",
                "765-887-78434", "Specialization2");
        Dentist robinPlevinDto = new Dentist("D102", "Robin", "Plevin", "robin.plevin@gmail.com",
                "765-887-78434", "Specialization1");

        Dentist tonySmith = dentistService.createDentist(tonySmithDto);
        Dentist helenPearson = dentistService.createDentist(helenPearsonDto);
        Dentist robinPlevin = dentistService.createDentist(robinPlevinDto);


        Address surgery10Addr = new Address("S10", "1000 North 4th Stret", "Fairfield", "IA");
        Address surgery13Addr = new Address("A13", "1000 North 4th Stret", "Fairfield", "IA");
        Address surgery15Addr = new Address("A15", "1000 North 4th Stret", "Fairfield", "IA");



        Surgery surgery0Dto = new Surgery("S10", "Surgey_A", surgery10Addr);
        Surgery surgery3Dto = new Surgery("S13", "Surgey_B", surgery13Addr);
        Surgery surgery5Dto = new Surgery("S15", "Surgey_C", surgery15Addr);

        Surgery surgery0 = surgeryService.createSurgery(surgery0Dto);
        Surgery surgery3 = surgeryService.createSurgery(surgery3Dto);
        Surgery surgery5 = surgeryService.createSurgery(surgery5Dto);

        Appointment appointment1Dto = new Appointment("APP101", gillianWhite, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
        Appointment appointment2Dto = new Appointment("APP102", jillBell, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
        Appointment appointment3Dto = new Appointment("APP103", ianMacKay, helenPearson, surgery0, LocalDate.of(2013, 9, 12));
        Appointment appointment4Dto = new Appointment("APP104", ianMacKay, helenPearson, surgery0, LocalDate.of(2013, 9, 14));
        Appointment appointment5Dto = new Appointment("APP105", jillBell, robinPlevin, surgery5, LocalDate.of(2013, 9, 14));
        Appointment appointment6Dto = new Appointment("APP106", gillianWhite, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
        Appointment appointment7Dto = new Appointment("APP107", johnWalker, robinPlevin, surgery3, LocalDate.of(2013, 9, 15));


        Arrays.asList(appointment1Dto, appointment2Dto,  appointment3Dto, appointment4Dto, appointment5Dto,
                appointment6Dto, appointment7Dto).forEach(appointment -> {
                    appointmentService.addAppointment(appointment);
        });

        System.out.println("--- List of patients ---");
        patientService.getAllPatients().forEach(System.out::println);
        System.out.println();

        System.out.println("--- List of dentists ---");
        dentistService.getAllDentists().forEach(System.out::println);
        System.out.println();

        System.out.println("--- List of surgeries ---");
        surgeryService.getAllSurgery().forEach(System.out::println);
        System.out.println();

        System.out.println("--- List of appointments ---");
        appointmentService.getAllAppointments().forEach(System.out::println);
        System.out.println();
    }

}

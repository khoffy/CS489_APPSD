package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AppointmentDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.*;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.AppointmentService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.DentistService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.PatientService;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class AdsDentalSurgeriesLab7Application {

    public static void main(String[] args) {
        SpringApplication.run(AdsDentalSurgeriesLab7Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientService patientService, DentistService dentistService,
                                        SurgeryService surgeryService, AppointmentService appointmentService) {

        return args -> {
            AddressDto gillianWhiteAddrDto = new AddressDto("A100", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            PatientDto gillianWhiteDto = new PatientDto("P100", "Gillian", "White", "gillian.white@gmail.com",
                    "641-555-8765", "555-233-8888", gillianWhiteAddrDto);
            PatientDto gillianWhite =  patientService.addPatient(gillianWhiteDto);

            AddressDto jillBellAddrDto = new AddressDto("A101", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            PatientDto jillBellDto = new PatientDto("P101", "jill", "Bell", "jill.bell@gmail.com",
                    "641-555-8765", "555-233-8888", jillBellAddrDto);
            PatientDto jillBell =  patientService.addPatient(jillBellDto);

            AddressDto ianMacKayAddrDto = new AddressDto("A102", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            PatientDto ianMacKayDto = new PatientDto("P102", "Ian", "MacKay", "ian.macKay@gmail.com",
                    "641-555-8765", "555-233-8888", ianMacKayAddrDto);
            PatientDto ianMacKay =  patientService.addPatient(ianMacKayDto);

            AddressDto johnWalkerAddrDto = new AddressDto("A103", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            PatientDto johnWalkerDto = new PatientDto("P103", "John", "Walker", "john.walker@gmail.com",
                    "641-555-8765", "555-233-8888", johnWalkerAddrDto);
            PatientDto johnWalker =  patientService.addPatient(johnWalkerDto);


            Address tonySmithAddr = new Address("A104", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            Address helenPearsonAddr = new Address("A105", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            Address robinPlevinAddr = new Address("A106", "1000 North 4th Stret", "Fairfield", "IA", "52557");

            Dentist tonySmithDto = new Dentist("D100", "Tony", "Smith", "tony.smith@gmail.com",
                    "765-887-78434", "Specialization1");
            Dentist helenPearsonDto = new Dentist("D101", "Helen", "Pearson", "helen.pearson@gmail.com",
                    "765-887-78434", "Specialization2");
            Dentist robinPlevinDto = new Dentist("D102", "Robin", "Plevin", "robin.plevin@gmail.com",
                    "765-887-78434", "Specialization1");

            Dentist tonySmith = dentistService.createDentist(tonySmithDto);
            Dentist helenPearson = dentistService.createDentist(helenPearsonDto);
            Dentist robinPlevin = dentistService.createDentist(robinPlevinDto);


            Address surgery10Addr = new Address("S10", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            Address surgery13Addr = new Address("A13", "1000 North 4th Stret", "Fairfield", "IA", "52557");
            Address surgery15Addr = new Address("A15", "1000 North 4th Stret", "Fairfield", "IA", "52557");



            Surgery surgery0Dto = new Surgery("S10", "Surgey_A", surgery10Addr);
            Surgery surgery3Dto = new Surgery("S13", "Surgey_B", surgery13Addr);
            Surgery surgery5Dto = new Surgery("S15", "Surgey_C", surgery15Addr);

            Surgery surgery0 = surgeryService.createSurgery(surgery0Dto);
            Surgery surgery3 = surgeryService.createSurgery(surgery3Dto);
            Surgery surgery5 = surgeryService.createSurgery(surgery5Dto);

            AppointmentDto appointment1Dto = new AppointmentDto("APP101", gillianWhiteDto, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
            AppointmentDto appointment2Dto = new AppointmentDto("APP102", jillBellDto, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
            AppointmentDto appointment3Dto = new AppointmentDto("APP103", ianMacKayDto, helenPearson, surgery0, LocalDate.of(2013, 9, 12));
            AppointmentDto appointment4Dto = new AppointmentDto("APP104", ianMacKayDto, helenPearson, surgery0, LocalDate.of(2013, 9, 14));
            AppointmentDto appointment5Dto = new AppointmentDto("APP105", jillBellDto, robinPlevin, surgery5, LocalDate.of(2013, 9, 14));
            AppointmentDto appointment6Dto = new AppointmentDto("APP106", gillianWhiteDto, tonySmith, surgery5, LocalDate.of(2013, 9, 12));
            AppointmentDto appointment7Dto = new AppointmentDto("APP107", johnWalkerDto, robinPlevin, surgery3, LocalDate.of(2013, 9, 15));


            Arrays.asList(appointment1Dto, appointment2Dto,  appointment3Dto, appointment4Dto, appointment5Dto,
                    appointment6Dto, appointment7Dto).forEach(appointmentService::addAppointment);

//            System.out.println("--- List of patients ---");
//            patientService.getAllPatients().forEach(System.out::println);
//            System.out.println();
//
//            System.out.println("--- List of dentists ---");
//            dentistService.getAllDentists().forEach(System.out::println);
//            System.out.println();
//
//            System.out.println("--- List of surgeries ---");
//            surgeryService.getAllSurgery().forEach(System.out::println);
//            System.out.println();
//
//            System.out.println("--- List of appointments ---");
//            appointmentService.getAllAppointments().forEach(System.out::println);
//            System.out.println();
        };
    }
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.web;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientService patientService;

    private final String urlString = "/adsweb/api/v1/patient";

    @GetMapping(value = urlString + "/list")
    public ResponseEntity<List<PatientDto>> getPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping(value = urlString + "/get/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("patientId") String patientId) {
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    @PostMapping(value = urlString + "/register")
    public ResponseEntity<PatientDto> registerPatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.OK);
    }




    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.web;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.PatientDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    //private final String urlString = "";

    @GetMapping(value = "/list")
    public ResponseEntity<List<PatientDto>> getPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("patientId") String patientId) {
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PatientDto> registerPatient(@Valid @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("patientId") String patientId, @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.updatePatient(patientId, patientDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable("patientId") String patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient successfully deleted", HttpStatus.OK);
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}

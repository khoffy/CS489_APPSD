package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, List<String>>> handleConstraintViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        Map<String, List<String>> errorsMap = new HashMap<>();
        constraintViolations.forEach(constraintViolation -> {
            List<String> fieldErrors = errorsMap.get(constraintViolation.getPropertyPath().toString());
            if(Objects.isNull(fieldErrors)) {
                errorsMap.put(constraintViolation.getPropertyPath().toString(), new ArrayList<>());
            }
            errorsMap.get(constraintViolation.getPropertyPath().toString()).add(constraintViolation.getMessage());
        });
        return ResponseEntity.badRequest().body(errorsMap);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

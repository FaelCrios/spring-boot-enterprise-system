package com.colin.springboot.springemployeers.errorHandling;

import com.colin.springboot.springemployeers.errorHandling.error.EmployeeNotFoundException;
import com.colin.springboot.springemployeers.errorHandling.response.EmployeeErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
          error.setStatus(HttpStatus.NOT_FOUND.value());
          error.setMessage(exc.getMessage());
          error.setTimeStamp(System.currentTimeMillis());

          return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}

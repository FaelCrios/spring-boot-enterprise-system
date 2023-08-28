package com.colin.springboot.springemployeers.errorHandling;

import com.colin.springboot.springemployeers.errorHandling.error.EmployeeNotFoundException;
import com.colin.springboot.springemployeers.errorHandling.response.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
          error.setStatus(HttpStatus.NOT_FOUND.value());
          error.setMessage(exc.getMessage());
          error.setTimeStamp(System.currentTimeMillis());

          return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

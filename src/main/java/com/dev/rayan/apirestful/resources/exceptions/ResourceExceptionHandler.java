package com.dev.rayan.apirestful.resources.exceptions;

import com.dev.rayan.apirestful.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request) {

        StandardError standardError = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Not found", exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }
}

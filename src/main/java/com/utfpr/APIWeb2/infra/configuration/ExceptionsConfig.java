package com.utfpr.APIWeb2.infra.configuration;

import com.utfpr.APIWeb2.core.exceptions.AuthenticationException;
import com.utfpr.APIWeb2.core.exceptions.CreateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsConfig {

    @ExceptionHandler(CreateUserException.class)
    public ResponseEntity<?> createUserExceptionn(CreateUserException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getCodeError() + " - " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globarException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleInvalidTokenException(AuthenticationException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getCodeError() + " - " + exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Runtime Exception");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}

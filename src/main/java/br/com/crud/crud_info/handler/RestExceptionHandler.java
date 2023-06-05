package br.com.crud.crud_info.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.crud.crud_info.model.error.ErrorMessage;
import br.com.crud.crud_info.model.exception.ResouceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(ResouceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResouceNotFoundException ex) {

    ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}

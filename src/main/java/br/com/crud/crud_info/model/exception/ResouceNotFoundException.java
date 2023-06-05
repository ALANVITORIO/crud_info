package br.com.crud.crud_info.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {
  public ResouceNotFoundException(String mensagem) {
    super(mensagem);
  }
}

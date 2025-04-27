package br.com.bytestorm.shortener.delivery.handler;

import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.domain.exceptions.FieldCannotEmptyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FieldCannotEmptyException.class)
    public ResponseEntity<Object> handleFieldCannotEmptyException(FieldCannotEmptyException e, WebRequest request) {
        MessageDTO error = new MessageDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }

}

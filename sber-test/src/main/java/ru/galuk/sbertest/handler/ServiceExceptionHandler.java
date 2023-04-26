package ru.galuk.sbertest.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import ru.galuk.sbertest.model.Error;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServiceExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Error> handleConstraintViolationException(HttpServerErrorException.InternalServerError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new Error().setCode(500).setMessage(ex.getMessage()));
    }
}

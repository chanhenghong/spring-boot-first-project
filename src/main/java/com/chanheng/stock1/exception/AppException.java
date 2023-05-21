package com.chanheng.stock1.exception;

import com.chanheng.stock1.api.base.RestError;
import com.chanheng.stock1.api.base.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppException{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    RestError<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        List<ValidationError> validationErrors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()){
            var validationError = ValidationError.builder()
                    .field(fieldError.getField())
                    .detail(fieldError.getDefaultMessage())
                    .build();
            validationErrors.add(validationError);
        }

        return RestError.builder()
                .message("Bad Request")
                .code(HttpStatus.BAD_REQUEST.value())
                .status(false)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .errors(validationErrors)
                .build();
    }
}

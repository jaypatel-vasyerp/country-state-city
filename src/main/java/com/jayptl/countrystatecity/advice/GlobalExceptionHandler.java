package com.jayptl.countrystatecity.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jayptl.countrystatecity.dto.ResponseDto;
import com.jayptl.countrystatecity.exception.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseDto EntityNotFoundExceptionHandler(EntityNotFoundException exception) {
        return new ResponseDto(404, "Error", exception.getMessage());
    }

}

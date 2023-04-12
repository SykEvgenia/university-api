package com.github.zhenya.university.api.controller;

import com.github.zhenya.university.api.dto.ErrorDto;
import com.mongodb.DuplicateKeyException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationException.class, MethodArgumentNotValidException.class, MissingServletRequestParameterException.class})
    public ErrorDto handlerException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DuplicateKeyException.class)
    public ErrorDto handlerException(DuplicateKeyException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(String.format("Елемент із заданими параметрами вже існує, детальне повідомлення про помилку [%s]", ex.getMessage()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    public ErrorDto handlerException(RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(ex.getMessage());
    }
}

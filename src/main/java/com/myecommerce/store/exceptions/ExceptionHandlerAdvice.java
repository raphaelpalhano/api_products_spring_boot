package com.myecommerce.store.exceptions;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    @ExceptionHandler(HttpException.class)
    public ResponseEntity<CustomErrorResponse> handlerBaseException(HttpException exception) {
        logger.error("Exception {}", exception.getMessage());
        
        CustomErrorResponse error = new CustomErrorResponse(exception.getMessage(), exception.getStatusCode(), exception.getDate());
        

        return ResponseEntity
                .status(exception.getStatusCode())
                .body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<CustomErrorResponse> handlerMethodThrowable(Throwable exception) {
        logger.error("Exception {}, Message: {}", exception.getClass().getName(), exception.getMessage());
        CustomErrorResponse error = new CustomErrorResponse(exception.getMessage(), 500, new Date());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }


    
}

package com.sharingsugar.authenticationservice.application.ExceptionAdvice;

import com.sharingsugar.authenticationservice.application.Response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());

        });
        List<String> errorList=new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorList.add(error.getDefaultMessage());

        });

        errorMap.put("status","400");
        Response response=new Response();
        response.setStatus("400");
        response.setMessage(errorList.toString());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        //return errorMap;
    }
}

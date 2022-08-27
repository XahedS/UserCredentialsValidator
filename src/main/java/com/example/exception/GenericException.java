package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GenericException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(Exception ex) {

        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        hashMap.put("trace", Arrays.toString(ex.getStackTrace()));
        return hashMap;
//        return ex.getMessage();
    }

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(InvalidEmailException ex) {

        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        return hashMap;
//        return ex.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(UserNotFoundException ex) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        return hashMap;
    }
}

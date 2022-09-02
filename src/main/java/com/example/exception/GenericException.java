package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;

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
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(InvalidPasswordException ex) {

        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        return hashMap;
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException( MethodArgumentNotValidException ex) {
        HashMap hashMap = new HashMap();
        int size = ex.getBindingResult().getAllErrors().size();
        for(int i = 0; i<size; i++)
            hashMap.put("error " + i, ex.getBindingResult().getAllErrors().get(i).getDefaultMessage());
        return hashMap;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(UserNotFoundException ex) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        return hashMap;
    }
}

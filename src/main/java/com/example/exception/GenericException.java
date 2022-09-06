package com.example.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

@ControllerAdvice
@ResponseBody
public class GenericException {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(Exception ex) {
        initDateTime();
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        hashMap.put("trace", Arrays.toString(ex.getStackTrace()));
        hashMap.put("Time Stamp: ", timeStamp);
        return hashMap;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(InvalidPasswordException ex) {
        initDateTime();
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        hashMap.put("Time Stamp: ", timeStamp);
        return hashMap;
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException( MethodArgumentNotValidException ex) {
        initDateTime();
        HashMap hashMap = new HashMap();
        int size = ex.getBindingResult().getAllErrors().size();
        for(int i = 0; i<size; i++) {
            hashMap.put("error " + i, ex.getBindingResult().getAllErrors().get(i).getDefaultMessage());
        }
        hashMap.put("Time Stamp: ", timeStamp.toString());
        return hashMap;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(UserNotFoundException ex) {
        initDateTime();
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        hashMap.put("Time Stamp: ", timeStamp);
        return hashMap;
    }

    private void initDateTime() {
        this.timeStamp = LocalDateTime.now();
    }
}

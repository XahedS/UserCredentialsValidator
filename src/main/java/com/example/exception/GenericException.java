package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashMap;

@ControllerAdvice
@ResponseBody
public class GenericException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(Exception ex) {
        System.out.println("I am in Generic Eception ------------<<<<<>>>>>>>>>>>>>>>-------------");
        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        hashMap.put("trace", Arrays.toString(ex.getStackTrace()));
        return hashMap;
//        return ex.getMessage();
    }

    @ExceptionHandler(InvalidPassword.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException(InvalidPassword ex) {

        HashMap hashMap = new HashMap();
        hashMap.put("error", ex.getMessage());
        return hashMap;
//        return ex.getMessage();
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleException( MethodArgumentNotValidException ex) {
        System.out.println("I think ConstraintViolationException based method is not called");

        HashMap hashMap = new HashMap();
//        hashMap.put("error", ex.getMessage());
        int size = ex.getBindingResult().getAllErrors().size();
        for(int i = 0; i<size; i++)
            hashMap.put("error " + i, ex.getBindingResult().getAllErrors().get(i).getDefaultMessage());
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

package com.example.controller;

import com.example.exception.InvalidPassword;
import com.example.exception.UserNotFoundException;
import com.example.model.UserCredentials;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@Valid @RequestBody UserCredentials user) throws UserNotFoundException, InvalidPassword {
        String replyMessage = userService.createUser(user);
        return replyMessage;
    }
}

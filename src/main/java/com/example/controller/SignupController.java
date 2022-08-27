package com.example.controller;

import com.example.exception.InvalidEmailException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) throws UserNotFoundException, InvalidEmailException {
        User savedUser = userService.createUser(user);
        return savedUser;
//        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
}

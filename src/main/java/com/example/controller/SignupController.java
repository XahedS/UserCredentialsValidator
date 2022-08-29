package com.example.controller;

import com.example.exception.InvalidPassword;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
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
    public User createUser(@Valid @RequestBody User user) throws UserNotFoundException, InvalidPassword {
        System.out.println(" I believe I dont visit UserService class  ++++++++++++SingupController++++++++++++");
        User savedUser = userService.createUser(user);
        return savedUser;
//        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
}

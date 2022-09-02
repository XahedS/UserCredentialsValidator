package com.example.controller;

import com.example.exception.InvalidPasswordException;
import com.example.exception.UserNotFoundException;
import com.example.model.ApiRepsone;
import com.example.model.UserCredential;
import com.example.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/signup", "/api"})
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Signups User",
    notes = "Registration request received against provided credentials",
    response = ApiRepsone.class)
    public ApiRepsone createUser(@ApiParam(value = "user data required for signup", required = true) @Valid @RequestBody UserCredential user) throws UserNotFoundException, InvalidPasswordException {
        ApiRepsone apiRepsone = userService.createUser(user);
        return apiRepsone;
    }
}

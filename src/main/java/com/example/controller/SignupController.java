package com.example.controller;

import com.example.exception.InvalidPasswordException;
import com.example.exception.UserNotFoundException;
import com.example.model.ApiRepsone;
import com.example.model.UserCredential;
import com.example.payload.UserCredentialDto;
import com.example.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"/signup"})
public class SignupController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Signups User",
    notes = "Registration request received against provided credentials",
    response = ApiRepsone.class)
    public ApiRepsone createUser(@ApiParam(value = "user data required for signup", required = true) @Valid @RequestBody UserCredentialDto userCredentialDto) throws UserNotFoundException, InvalidPasswordException {
        UserCredential userCredential = modelMapper.map(userCredentialDto, UserCredential.class);
        Map<UserCredential, String> createUserResponseMap = new HashMap();
        String responseMessage = userService.createUser(userCredential);
        return new ApiRepsone(modelMapper.map(userCredential, UserCredentialDto.class), responseMessage);
    }
}

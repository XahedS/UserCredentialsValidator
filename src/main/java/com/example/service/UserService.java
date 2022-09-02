package com.example.service;

import com.example.exception.InvalidPasswordException;
import com.example.exception.UserNotFoundException;
import com.example.model.ApiRepsone;
import com.example.model.UserCredential;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
//    @Autowired
    public ApiRepsone apiRepsone = new ApiRepsone();

//    @Transactional
    public ApiRepsone createUser(UserCredential user) throws UserNotFoundException, InvalidPasswordException {
        if (userRepository.findByName(user.getName()).isPresent()) {
            apiRepsone.setResponseMessage("User: " + user.getName() +" already registered");
            return apiRepsone; //response should be an object
        } else {
            userRepository.save(user);
            user.setRegistrationStatus(true);
            apiRepsone.setResponseMessage("User: " + user.getName() +" registered successfully");
            return apiRepsone; //response should be an object
        }
    }
}

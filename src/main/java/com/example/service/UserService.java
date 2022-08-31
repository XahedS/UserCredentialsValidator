package com.example.service;

import com.example.exception.InvalidPassword;
import com.example.exception.UserNotFoundException;
import com.example.model.UserCredentials;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Transactional
    public String createUser(UserCredentials user) throws UserNotFoundException, InvalidPassword {

        List<UserCredentials> userCredentials = userRepository.findByNameEquals(user.getName());
        if (userCredentials.stream().filter(userCredential -> userCredential.getName().equals(user.getName())).count() != 0) {
            return "User already registered";
        } else {
            userRepository.save(user);
            user.setRegistrationStatus(true);
            return "User registered successfully";
        }
    }
}

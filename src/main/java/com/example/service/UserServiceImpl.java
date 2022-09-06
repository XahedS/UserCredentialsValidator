package com.example.service;

import com.example.exception.InvalidPasswordException;
import com.example.exception.UserNotFoundException;
import com.example.model.UserCredential;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface{

    @Autowired
    public UserRepository userRepository;
    @Override
    public String createUser(UserCredential user) throws UserNotFoundException, InvalidPasswordException {
        if (userRepository.existsByName(user.getName())) { //throws exception!!!
            return "Username Already Exists";
        } else {
            user.setRegistrationStatus(true);
            UserCredential userCredential = userRepository.save(user);
            return "User Created";
        }
    }

    public UserCredential getUser(String username) throws UserNotFoundException {
        UserCredential userCredential = userRepository.findByName(username)
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        return userCredential;
    }
}

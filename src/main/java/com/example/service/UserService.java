package com.example.service;

import com.example.exception.InvalidEmailException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
//import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

//    @Transactional
    public User createUser(User user) throws UserNotFoundException, InvalidEmailException {
        if(user.getUserName().equals(null))
        {
            throw new UserNotFoundException("User name is null");
        }

        if(!user.getEmail().contains("@")) {
            throw new InvalidEmailException("Invalid Email");
        }
//        return userRepository.save(user);
        return user;
    }
}

package com.example.service;

import com.example.exception.InvalidPasswordException;
import com.example.exception.UserNotFoundException;
import com.example.model.UserCredential;

public interface UserServiceInterface {
    String createUser(UserCredential user) throws UserNotFoundException, InvalidPasswordException;
}

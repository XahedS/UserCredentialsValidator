package com.example.service;

import com.example.exception.InvalidPassword;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import org.springframework.stereotype.Service;
import javax.validation.constraints.Pattern;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

//    @Transactional
    public User createUser(User user) throws UserNotFoundException, InvalidPassword {

        //        if(user.getUserName().equals(null))
//        {
//            throw new UserNotFoundException("User name is null");
//        }

//        if(!user.getEmail().contains("@")) {
//            throw new InvalidEmailException("Invalid Email");
//        }
//        return userRepository.save(user);
        return user;
    }

    private boolean validateUserCredentials(User user)  throws UserNotFoundException, InvalidPassword {
        @Pattern(regexp = "^[a-zA-Z0-9]*$",//"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",//regexp = "^[a-zA-Z0-9]{6,12}$",
                message = "username must be of 6 to 12 length with no special characters")
        String name = user.getUserName();

        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
                message = "password must contain atleast 1 uppercase, 1 lowercase, 1 digit & should be of min length 8 ")
        String passowrd = user.getPassword();

        return true;

    }
}

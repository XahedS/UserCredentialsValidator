package com.example.model;

import com.example.exception.InvalidPassword;
import com.example.exception.UserNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Entity
@Validated
public class User {
    public User(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]*$",//"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",//regexp = "^[a-zA-Z0-9]{6,12}$",
                    message = "username must be of 6 to 12 length with no special characters")
    private String userName;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 digit & should be of min length 8 ")
    private String password;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }
}

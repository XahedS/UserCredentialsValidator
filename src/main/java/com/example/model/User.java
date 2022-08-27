package com.example.model;

import com.example.exception.InvalidEmailException;
import lombok.*;
import org.springframework.stereotype.Component;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
@Component
public class User {

    public User(){

    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @NonNull
//    @NotBlank(message = "username is mandatory")
    private String userName;

//    @NonNull
//    @NotEmpty
//    @Email
    private String email;

//    @ValidPassword
//    @NonNull
//    @NotBlank(message = "password is mandatory")
    private String password;

    public int getId() {
        return id;
    }

    public String getUserName() {

        return userName;
    }

    public String getEmail() throws InvalidEmailException {

        return email;
    }

    public String getPassword() {
        return password;
    }
}

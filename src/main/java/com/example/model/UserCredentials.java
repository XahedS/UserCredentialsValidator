package com.example.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="UserCredentials")
@Validated
public class UserCredentials {
    public UserCredentials(){
    }

    public UserCredentials(int id, String email, String userName, String password, boolean registrationStatus) {
        this.id = id;
        this.email = email;
        this.name = userName;
        this.password = password;
        this.registrationStatus = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean registrationStatus = false;
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]*$",//"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",//regexp = "^[a-zA-Z0-9]{6,12}$",
                    message = "username must be of 6 to 12 length with no special characters")
    private String name;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 digit & should be of min length 8 ")
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}

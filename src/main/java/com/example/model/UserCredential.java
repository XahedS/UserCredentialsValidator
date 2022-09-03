package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
//import org.springframework.context.MessageSource;
import com.example.config.ApiConfiguration;

@Entity
@Table(name="usercredential")
//@Validated
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean registrationStatus = false;
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]*$",
                    message = "{error.username.message}")// "username must be of 6 to 12 length with no special characters") //Put the messages in external file; message.properties
    @Column(name = "username", unique = true)
    private String name;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 digit & should be of min length 8 ")
    private String password;

    public UserCredential(){
    }

    public UserCredential(int id, String email, String userName, String password, boolean registrationStatus) {
        this.id = id;
        this.email = email;
        this.name = userName;
        this.password = password;
        this.registrationStatus = false;
    }

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

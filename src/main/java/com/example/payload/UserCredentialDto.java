package com.example.payload;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class UserCredentialDto {
    private int id;
    private boolean registrationStatus;
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]*$",
            message = "{error.username.message}")// "username must be of 6 to 12 length with no special characters") //Put the messages in external file; message.properties
    private String name;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 digit & should be of min length 8 ")
    private String password;

}

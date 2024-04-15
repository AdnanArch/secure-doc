package com.adnanarch.securedoc.dtorequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 8:24 PM
 * Version: 1.0
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    @NotEmpty(message = "First Name can not be empty.")
    private String firstName;
    @NotEmpty(message = "Last Name can not be empty.")
    private String lastName;
    @NotEmpty(message = "Email can not be empty.")
    @Email(message = "Invalid Email Address")
    private String email;
    @NotEmpty(message = "Password can not be empty.")
    private String password;
    private String phone;
    private String bio;
}

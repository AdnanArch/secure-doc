package com.adnanarch.securedoc.controller;

import com.adnanarch.securedoc.dtorequest.UserRequest;
import com.adnanarch.securedoc.model.Response;
import com.adnanarch.securedoc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.adnanarch.securedoc.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 8:15 PM
 * Version: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<Response> createUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap(), "Account created. Check your email to enable your account.", CREATED));
    }

    private URI getUri() {
        return URI.create("");
    }

}

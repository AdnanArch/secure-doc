package com.adnanarch.securedoc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 8:20 PM
 * Version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record Response(
        String time,
        int code,
        String path,
        HttpStatus status,
        String message,
        String exception,
        Map<?, ?> data) {
}

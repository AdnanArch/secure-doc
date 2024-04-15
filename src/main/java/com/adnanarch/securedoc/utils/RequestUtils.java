package com.adnanarch.securedoc.utils;

import com.adnanarch.securedoc.model.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 8:34 PM
 * Version: 1.0
 */

public class RequestUtils {
    public static Response getResponse(HttpServletRequest request, Map<?, ?> data, String message, HttpStatus status) {
        return new Response(
                now().toString(),
                status.value(),
                request.getRequestURI(),
                HttpStatus.valueOf(status.value()),
                message,
                EMPTY,
                data
        );
    }
}

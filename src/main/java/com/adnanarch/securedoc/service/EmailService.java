package com.adnanarch.securedoc.service;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 11:40 AM
 * Version: 1.0
 */

public interface EmailService {
    void sendNewAccountEmail(String name, String email, String token);
    void sendPasswordResetEmail(String name, String email, String token);
}

package com.adnanarch.securedoc.exception;

/**
 * Author: Adnan Rafique
 * Date: 4/5/2024
 * Time: 10:21 AM
 * Version: 1.0
 */

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }

    public ApiException(){
        super("An error occurred");
    }
}

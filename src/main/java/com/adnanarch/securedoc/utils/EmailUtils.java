package com.adnanarch.securedoc.utils;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 12:03 PM
 * Version: 1.0
 */

public class EmailUtils {
    public static String getEmailMessage(String name, String host, String token){
        return "Hello" + name + ",\n\nYour account has been created. Please click on the " +
                "link below to verify your account.\n\n" + getVerificationUrl(host, token) +
                "\n\nThe Support Team";
    }

    public static String getResetPasswordMessage(String name, String host, String token){
        return "Hello" + name + ",\n\nYour account has been created. Please click on the " +
                "link below to verify your account.\n\n" + getResetPasswordUrl(host, token) +
                "\n\nThe Support Team";
    }

    public static String getVerificationUrl(String host, String token) {
        return host + "/verify/account?token=" + token;
    }

    public static String getResetPasswordUrl(String host, String token) {
        return host + "/verify/password?token=" + token;
    }
}

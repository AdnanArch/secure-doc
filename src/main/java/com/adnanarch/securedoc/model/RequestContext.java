package com.adnanarch.securedoc.model;

/**
 * Author: Adnan Rafique
 * Date: 4/5/2024
 * Time: 10:11 AM
 * Version: 1.0
 */

public class RequestContext {
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    private RequestContext() {
    }

    public static void start() {
        USER_ID.remove();
    }

    public static void setUserId(Long userId) {
        USER_ID.set(userId);
    }

    public static Long getUserId() {
        return USER_ID.get();
    }

}
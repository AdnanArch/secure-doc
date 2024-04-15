package com.adnanarch.securedoc.service;

import com.adnanarch.securedoc.entity.RoleEntity;
import org.apache.catalina.User;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 7:04 PM
 * Version: 1.0
 */

public interface UserService {
    void createUser(String firstname, String lastname, String email, String password);
    RoleEntity getRoleName(String name);
}

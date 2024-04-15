package com.adnanarch.securedoc.utils;

import com.adnanarch.securedoc.entity.RoleEntity;
import com.adnanarch.securedoc.entity.UserEntity;

import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 7:34 PM
 * Version: 1.0
 */

public class UserUtils {
    public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role){
       return  UserEntity.builder()
               .userId(UUID.randomUUID().toString())
               .firstName(firstName)
               .lastName(lastName)
               .email(email)
               .role(role)
               .lastLogin(now())
               .accountNonExpired(true)
               .accountNonLocked(true)
               .loginAttempts(0)
               .qrCodeImageUri(EMPTY)
               .qrCodeSecret(EMPTY)
               .phone(EMPTY)
               .bio(EMPTY)
               .imageUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png")
               .build();
    }
}

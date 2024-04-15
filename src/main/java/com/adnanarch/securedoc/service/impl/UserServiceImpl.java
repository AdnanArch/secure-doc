package com.adnanarch.securedoc.service.impl;

import com.adnanarch.securedoc.entity.ConfirmationEntity;
import com.adnanarch.securedoc.entity.CredentialEntity;
import com.adnanarch.securedoc.entity.RoleEntity;
import com.adnanarch.securedoc.entity.UserEntity;
import com.adnanarch.securedoc.enumeration.Authority;
import com.adnanarch.securedoc.enumeration.EventType;
import com.adnanarch.securedoc.event.UserEvent;
import com.adnanarch.securedoc.exception.ApiException;
import com.adnanarch.securedoc.repository.ConfirmationRepository;
import com.adnanarch.securedoc.repository.CredentialRepository;
import com.adnanarch.securedoc.repository.RoleRepository;
import com.adnanarch.securedoc.repository.UserRepository;
import com.adnanarch.securedoc.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.adnanarch.securedoc.utils.UserUtils.createUserEntity;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 7:05 PM
 * Version: 1.0
 */

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;


    @Override
    public void createUser(String firstname, String lastname, String email, String password) {
        var userEntity = userRepository.save(createNewUser(firstname, lastname, email));
        var credentialEntity = new CredentialEntity(userEntity, password);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key", confirmationEntity.getKey())));
    }

    @Override
    public RoleEntity getRoleName(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return role.orElseThrow(() -> new ApiException("Role Not found"));
    }

    private UserEntity createNewUser(String firstName, String lastName, String email){
        var role = getRoleName(Authority.USER.name());
        return createUserEntity(firstName, lastName, email, role);
    }
}

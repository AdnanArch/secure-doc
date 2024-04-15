package com.adnanarch.securedoc.repository;

import com.adnanarch.securedoc.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 6:27 PM
 * Version: 1.0
 */

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
    Optional<CredentialEntity> getCredentialByUserEntityId(Long userID);
}

package com.adnanarch.securedoc.repository;

import com.adnanarch.securedoc.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: Adnan Rafique
 * Date: 4/7/2024
 * Time: 6:26 PM
 * Version: 1.0
 */

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByNameIgnoreCase(String name);
}

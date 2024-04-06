package com.adnanarch.securedoc.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.OnDelete;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 11:20 AM
 * Version: 1.0
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credentials")
@JsonInclude(NON_DEFAULT)
public class CredentialEntity extends Auditable{
    private String password;
    @OneToOne(targetEntity = UserEntity.class, fetch = EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("user_id")
    private UserEntity userEntity;

    public CredentialEntity(UserEntity userEntity, String password) {
        this.password = password;
        this.userEntity = userEntity;
    }
}

package com.adnanarch.securedoc.entity;

import com.adnanarch.securedoc.exception.ApiException;
import com.adnanarch.securedoc.model.RequestContext;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Author: Adnan Rafique
 * Date: 4/5/2024
 * Time: 12:51 AM
 * Version: 1.0
 */

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAr"}, allowGetters = true)
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();

    @NotNull
    private Long createdBy;

    @NotNull
    private Long updatedBy;

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void beforePersist() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new ApiException("Cannot persist entity without user Id in Request for this thread.");
        }
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }

    @PreUpdate
    protected void beforeUpdate() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new ApiException("Cannot update entity without use Id in Request Context for this thread.");
        }
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }
}

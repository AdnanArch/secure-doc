package com.adnanarch.securedoc.event;

import com.adnanarch.securedoc.entity.UserEntity;
import com.adnanarch.securedoc.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 12:18 PM
 * Version: 1.0
 */

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    private UserEntity userEntity;
    private EventType eventType;
    private Map<?, ?> eventData;
}

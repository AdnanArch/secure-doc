package com.adnanarch.securedoc.event.listener;

import com.adnanarch.securedoc.event.UserEvent;
import com.adnanarch.securedoc.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 12:20 PM
 * Version: 1.0
 */

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent event) {
        switch (event.getEventType()){
            case REGISTRATION-> emailService.sendNewAccountEmail(event.getUserEntity().getFirstName(), event.getUserEntity().getEmail(), event.getEventData().get("key").toString());
            case RESET_PASSWORD -> emailService.sendPasswordResetEmail(event.getUserEntity().getFirstName(), event.getUserEntity().getEmail(), event.getEventData().get("key").toString());
            default -> {}
        }
    }
}

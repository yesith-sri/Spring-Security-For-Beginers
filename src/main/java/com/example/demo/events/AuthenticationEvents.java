package com.example.demo.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEvents {

    @EventListener
public void onSuccess(AuthenticationSuccessEvent authentication) {
        log.info("Authentication success : {}", authentication.getAuthentication().getName());
    }

@EventListener
    public void onFailure(AbstractAuthenticationFailureEvent authenticationFailure   ) {

        log.error("Authentication failure : {} | Due to to :- {}", authenticationFailure.getAuthentication().getName()
        , authenticationFailure.getException().getMessage());
}
}


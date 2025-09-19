package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SecurityController {

   private final PasswordEncoder passwordEncoder;

    @GetMapping("/test/{username}")
    public String login(@PathVariable String username) {
        return ("Login: " + username);
    }

    @GetMapping("/hello")
    public String sayhello() {
        log.info(passwordEncoder.encode("hello"));
        return ("Say hello");
    }
}

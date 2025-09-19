package com.example.demo.service.impl;

import com.example.demo.dto.Customerdto;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repositary.CustomerRepositary;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    private final CustomerRepositary customerRepositary;
    @Override
    public ResponseEntity<String> createUser(Customerdto customerDto) {

        try {
            String encode = passwordEncoder.encode(customerDto.getPassword());
            log.info(encode);
            customerDto.setPassword(encode);
            CustomerEntity save = customerRepositary.save(objectMapper.convertValue(customerDto, CustomerEntity.class));
            return ResponseEntity.ok(save.toString());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
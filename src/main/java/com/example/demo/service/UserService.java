package com.example.demo.service;


import com.example.demo.dto.Customerdto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> createUser(Customerdto customerDto);
}


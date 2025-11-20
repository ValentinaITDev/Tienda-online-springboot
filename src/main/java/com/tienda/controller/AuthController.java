package com.tienda.controller;

import com.tienda.dto.LoginRequestDTO;
import com.tienda.dto.LoginResponseDTO;
import com.tienda.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}

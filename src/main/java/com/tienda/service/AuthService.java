package com.tienda.service;

import com.tienda.dto.LoginRequestDTO;
import com.tienda.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}

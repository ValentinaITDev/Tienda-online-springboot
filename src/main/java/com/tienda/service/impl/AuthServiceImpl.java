package com.tienda.service.impl;

import com.tienda.dto.LoginRequestDTO;
import com.tienda.dto.LoginResponseDTO;
import com.tienda.entity.Usuario;
import com.tienda.repository.UsuarioRepository;
import com.tienda.security.jwt.JwtUtils;
import com.tienda.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getCorreoElectronico(),
                loginRequest.getContrasena()
            )
        );
        
        String token = jwtUtils.generateToken(loginRequest.getCorreoElectronico());
        
        Usuario usuario = usuarioRepository.findByCorreoElectronico(loginRequest.getCorreoElectronico())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        return new LoginResponseDTO(token, usuario.getIdUsuario(), usuario.getNombre(), usuario.getCorreoElectronico());
    }
}

package com.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String tipo = "Bearer";
    private Long idUsuario;
    private String nombre;
    private String correoElectronico;
    
    public LoginResponseDTO(String token, Long idUsuario, String nombre, String correoElectronico) {
        this.token = token;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }
}

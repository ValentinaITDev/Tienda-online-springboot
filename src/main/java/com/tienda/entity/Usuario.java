package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String correoElectronico;
    
    @Column(nullable = false)
    private String contrasena;
    
    private String direccion;
    
    private String metodoDePago;
}

package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @Column(nullable = false, length = 1000)
    private String comentario;
    
    @Column(nullable = false)
    private LocalDate fecha;
}

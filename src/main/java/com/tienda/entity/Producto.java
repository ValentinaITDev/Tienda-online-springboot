package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    
    @Column(nullable = false)
    private String nombre;
    
    private String descripcion;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(nullable = false)
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}

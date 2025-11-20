package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDeCompras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToMany
    @JoinTable(
        name = "carrito_productos",
        joinColumns = @JoinColumn(name = "id_carrito"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos = new ArrayList<>();
    
    @Column(nullable = false)
    private Double subtotal = 0.0;
    
    @Column(nullable = false)
    private Double impuestos = 0.0;
}

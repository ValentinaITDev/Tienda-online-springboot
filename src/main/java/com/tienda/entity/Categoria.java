package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    
    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos;
}

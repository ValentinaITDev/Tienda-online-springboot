package com.tienda.repository;

import com.tienda.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByFechaGreaterThanEqual(LocalDate fecha);
}

package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository < Comentario , Integer> {
    List<Comentario> findAllByFecha(LocalDateTime fecha);
    Page<Comentario> findAll(Pageable paginador);
}


package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo  extends  JpaRepository <Producto, Integer>{

    List <Producto> findAllByNombreContains(String nombre);

    List<Producto> findAllByDescripcion(String descripcion);

    Page<Producto> findAll(Pageable paginador);
    @Query ("select c from Producto p, IN (p.comentario) c where p.codigo = :id")
    List<Comentario> obtenerComentarios(Integer id);
}

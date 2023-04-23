package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo  extends  JpaRepository <Producto, Integer>{

    List <Producto> findAllByNombreContainsIgnoreCase(String nombre);

    List<Producto> findAllByDescripcionContainsIgnoreCase(String descripcion);

    List<Producto> findAllByUsuario_Cedula(String cedula);


    List<Producto> findAllByCategoriasContains(Categoria_Producto categoria);

    List<Producto> findAllByEstado(Estado_Producto estado);

    List<Producto> findAllByIsDisponible(Boolean isDisponible);

    List<Producto> findAllByIsActivo(Boolean isActivo);

    @Query ("select p from Producto p where p.precio between :precio1 and :precio2")
    List<Producto> listarPorRangoDePrecio(Double precio1, Double precio2);

    Page<Producto> findAll(Pageable paginador);

    @Query ("select p from Usuario u, IN (u.productosFavoritos) p where u.cedula = :cedula")
    List<Producto> obtenerProductosDeUsuarioFavoritos(String cedula);


}

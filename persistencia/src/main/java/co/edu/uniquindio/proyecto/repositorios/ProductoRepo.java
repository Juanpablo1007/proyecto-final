package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo  extends  JpaRepository <Producto, Integer>{

    List <Producto> findAllByNombreContains(String nombre);

    List<Producto> findAllByDescripcion(String descripcion);

    Page<Producto> findAll(Pageable paginador);
    //@Query ("select Producto.usuario.nombre from Producto p where p.codigo = :id")
    //String obtenerNombreVendedor(Integer id);
}

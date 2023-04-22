package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository

public interface UsuarioRepo extends JpaRepository <Usuario, String> {
    List <Usuario> findAllByNombreContains(String nombre);

    Optional <Usuario> findByEmail(String email);

    Optional<Usuario> findByEmailAndContraseña (String email, String contraseña);
    Page <Usuario>findAll(Pageable paginador);
@Query ("select p from Usuario u, IN (u.productosFavoritos) p where u.email = :email")
    List<Producto> obtenerProductoFavorito(String email);
    @Query ("select c from Usuario u, IN (u.comentarios) c where u.cedula = :id")
    List<Comentario> obtenerComentarios(String id);

    @Query ("select u.email, p from Usuario u join  u.productos p ")
    List<Object[]> listarUsuarioProductos();

}

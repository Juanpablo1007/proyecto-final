package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    Usuario registrarUsuario  (Usuario u) throws Exception;

    Usuario ActualizarUsuario  (Usuario u) throws Exception;

    void EliminarUsuario  (String cedula) throws Exception;

    List<Usuario> listarUsuario()  throws Exception;
    Optional <Usuario> logUsuario  (String correo, String contraseña) throws Exception;

    Producto publicarProducto  (Producto producto) throws Exception;

    Producto comentarProducto (Comentario comentario, Producto producto)  throws Exception;

    void guardarProductoFavorito (Producto producto) throws Exception;

    void quitarProductoFavorito (Producto producto) throws Exception;

    Compra comprarProducto (Carrito carrito)  throws Exception;

    void RecuperarContraseña (String email, String contraseña)  throws Exception;



    List<Producto> listarProductoPrecio(Double precioBajo, Double precioAlto) throws Exception;

    List<Producto> buscarProductoNombre (String nombre)  throws Exception;
    List<Compra> listarCompras (Usuario u)  throws Exception;

    List<Producto> listarProductosPublicados ()  throws Exception;
    List<Producto> listarProductosFavoritos (String cedula)  throws Exception;

    Producto ActualizarProducto  (Producto producto) throws Exception;

    void EliminarProducto  (Producto producto) throws Exception;





}
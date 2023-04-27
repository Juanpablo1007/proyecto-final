package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto  (Producto producto,Usuario usuario) throws Exception;

    Producto comentarProducto (Producto p, Comentario co,Usuario u)  throws Exception;

    void guardarProductoFavorito (Producto producto, Usuario usuario) throws Exception;

    void quitarProductoFavorito (Producto producto, Usuario usuario) throws Exception;

    List<Producto> listarProductoPrecio(Double precioBajo, Double precioAlto) throws Exception;

    List<Producto> buscarProductoNombre (String nombre)  throws Exception;

    List<Producto> listarProductosPublicados (String cedula)  throws Exception;
    List<Producto> listarProductosFavoritos (Usuario u)  throws Exception;

    Producto ActualizarProducto  (Producto producto) throws Exception;

    void EliminarProducto  (Producto producto) throws Exception;

}

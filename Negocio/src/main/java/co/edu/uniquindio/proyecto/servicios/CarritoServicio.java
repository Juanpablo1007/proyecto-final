package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Carrito;
import co.edu.uniquindio.proyecto.entidades.Producto;

public interface CarritoServicio {

    Carrito asignarCarrito(Carrito carrito, String cedula) throws Exception;

    void agregarProducto(Integer codigoProduto, Integer codigoCarrito,Integer unidades) throws Exception;

    void eliminar(Integer codigoProducto, Carrito carrito) throws Exception;

    void calcularTotalCarrito(Integer codigoCarrito);


}

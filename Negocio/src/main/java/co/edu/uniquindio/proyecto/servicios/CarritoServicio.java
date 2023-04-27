package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

public interface CarritoServicio {

    Carrito asignarCarrito(Carrito carrito, Usuario usuario) throws Exception;

    CarritoProductos agregarProducto(Integer codigoProduto, Integer codigoCarrito, Integer unidades) throws Exception;

    Boolean eliminarProducto(CarritoProductosLlave codigo) throws Exception;

    Double calcularTotalCarrito(Integer codigoCarrito);


}

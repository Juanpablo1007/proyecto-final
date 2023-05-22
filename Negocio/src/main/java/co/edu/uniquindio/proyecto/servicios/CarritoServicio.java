package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

public interface CarritoServicio {

    Carrito asignarCarrito(Carrito carrito, String usuarioCedula) throws Exception;

    CarritoProductos agregarProducto(Integer codigoProduto, Integer codigoCarrito, Integer unidades) throws Exception;

    CarritoProductos eliminarProducto(CarritoProductosLlave codigo) throws Exception;

    Double calcularTotalCarrito(Integer codigoCarrito);


}

package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

public interface CompraServicio {

    Compra realizarCompra(Compra compra, Usuario u, Producto p)  throws Exception;
}

package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;

public interface CompraServicio {

    Compra realizarCompra(Compra compra, Usuario u, Producto p)  throws Exception;

    Double calcularTotalCompra(Integer total);

    List<Compra> listarComprasDeUsuario (Usuario u) throws Exception;
}

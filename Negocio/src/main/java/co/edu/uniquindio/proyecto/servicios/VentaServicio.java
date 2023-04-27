package co.edu.uniquindio.proyecto.servicios;
import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.stereotype.Service;


public interface VentaServicio {
    Venta realizarVenta(Venta venta, Usuario u, Producto p)  throws Exception;

    Double calcularTotal (Integer total);
}

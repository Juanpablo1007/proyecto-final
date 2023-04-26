package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.*;

public interface ModeradorServicio {

    Moderador registrarModerador (Moderador u) throws Exception;

   Moderador prohibirProducto (Producto u) throws Exception;

    Moderador AutorizarProducto (Producto u) throws Exception;

}

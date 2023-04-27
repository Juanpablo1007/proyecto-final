package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;
import java.util.Optional;

public interface ModeradorServicio {

Moderador registrarModerador (Moderador mod) ;
   void prohibirProducto (Producto u) throws Exception;

   Optional<Moderador> loginMod (String email, String contraseña) throws Exception;

    void AutorizarProducto (Producto u) throws Exception;

    List<Producto> listarProductosPorEstado();

}

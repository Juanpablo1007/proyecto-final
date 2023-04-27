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


    void RecuperarContraseña (String email, String contraseña)  throws Exception;


}

package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.ModeradorPostDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.SesionPostDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;
import java.util.Optional;

public interface ModeradorServicio {

   void registrarModerador (ModeradorPostDTO moderadorPostDTO) ;
   void prohibirProducto (Integer productoCodigo) throws Exception;

   ModeradorGetDTO loginMod (SesionPostDTO sesionPostDTO) throws Exception;

    void AutorizarProducto (Integer productoCodigo) throws Exception;

    List<ProductoGetDTO> listarProductosPorEstado();

    ModeradorGetDTO obtenerModeradorPorCedula(String cedula) throws Exception;

    List<ModeradorGetDTO> listarModeradores();

}

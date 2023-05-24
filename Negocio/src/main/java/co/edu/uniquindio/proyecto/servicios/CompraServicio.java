package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.CompraPostDTO;
import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;

public interface CompraServicio {

    void realizarCompra(CompraPostDTO compraPostDTO) throws Exception;

    Double calcularTotalCompra(Integer codigo);

    //List<CompraGetDTO> listarComprasDeUsuario (String usuarioCedula) throws Exception;

}

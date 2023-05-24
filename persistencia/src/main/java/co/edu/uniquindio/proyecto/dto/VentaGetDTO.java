package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.MetodoDePago;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VentaGetDTO {

    private LocalDateTime fecha;
    private Double total;
    private String usuarioCedula;
    private MetodoDePago metodoDePago;
    private ProductoGetDTO producto;
    private Integer unidadesVendidas;
}

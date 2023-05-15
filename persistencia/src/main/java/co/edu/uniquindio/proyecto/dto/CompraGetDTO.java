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
public class CompraGetDTO {

    private Integer codigo;
    private LocalDateTime fecha;
    private Double total;
    private Usuario usuario;
    private MetodoDePago metodoDePago;
    private Producto producto;
    private Integer unidadesCompradas;
}

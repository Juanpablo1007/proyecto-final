package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComentarioGetDTO {
    private Integer codigo;
    private String texto;
    private LocalDateTime fecha;
    private Usuario usuario;
    private Producto producto;
}

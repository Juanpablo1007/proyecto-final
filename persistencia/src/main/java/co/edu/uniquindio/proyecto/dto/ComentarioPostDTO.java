package co.edu.uniquindio.proyecto.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComentarioPostDTO {
    @NotEmpty(message = "El texto del comentario no puede estar vacio")
    @Length(max = 100, message = "El comentario debe ser de 100 o menos caracteres")
    private String texto;
    private String usuarioCedula;
    private Integer productoCodigo;

}

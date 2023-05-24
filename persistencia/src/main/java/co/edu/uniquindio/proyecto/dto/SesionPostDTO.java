package co.edu.uniquindio.proyecto.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SesionPostDTO {

    @NotEmpty(message = "la contraseña no puede estar vacia")
    @Length(max = 100, message = "La contraseña ser de 100 caracteres o menos")
    private String contraseña;
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Length(max = 100, message = "El nombre debe ser de 100 caracteres o menos")
    private String nombre;
}

package co.edu.uniquindio.proyecto.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
public class EmailDto {
    @NotEmpty(message = "")
    @Length(max = 100, message = "")
    private String asunto;

    @NotEmpty(message = "")
    @Length(max = 2000, message = "")
    private String cuerpo;

    @NotEmpty(message = "")
    @Length(max = 100, message = "")
    private String destinatario;
}

package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class MensajeDTO {
    private HttpStatus httpStatus;
    private boolean flag;
    private Object mensaje;


}

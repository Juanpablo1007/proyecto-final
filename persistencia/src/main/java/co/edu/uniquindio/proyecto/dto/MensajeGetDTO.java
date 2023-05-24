package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class MensajeGetDTO {
    private HttpStatus httpStatus;
    private boolean flag;
    private Object mensaje;


}

package co.edu.uniquindio.proyecto.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
public class InfoUsuarioVenta {
    String nombre;
    String email;
    Long registro;

    public InfoUsuarioVenta(String nombre, String email, Long registro) {
        this.nombre = nombre;
        this.email = email;
        this.registro = registro;
    }
}

package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModeradorGetDTP {
    private String cedula;
    private String contraseña;
    private String nombre;
    private String email;
}

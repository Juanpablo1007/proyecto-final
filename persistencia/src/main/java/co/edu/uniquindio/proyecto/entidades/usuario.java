package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String cedula;
private String contraseña;



private Estado_Cuenta estado;

private String nombre;

    private String telefono;

    private String direccion;
    private String correo;











}

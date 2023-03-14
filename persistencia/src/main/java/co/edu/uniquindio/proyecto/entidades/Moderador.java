package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Moderador extends Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column (length = 15)

    private String cedula;

    @Column ( nullable = false)
    private String contraseña;

    @Column ( nullable = false)

    private String nombre;

    @Column ( nullable = false, unique = true)
    private String correo;

}

package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Moderador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column ( nullable = false, length = 100)
    @NotBlank(message = "El moderador debe tener una contraseña")
    private String contraseña;
    @Column ( nullable = false, length = 100)
    @NotBlank(message = "El moderador debe tener un nombre")
    private String nombre;
    @Column ( nullable = false, unique = true, length = 100)
    @Email
    private String email;


}

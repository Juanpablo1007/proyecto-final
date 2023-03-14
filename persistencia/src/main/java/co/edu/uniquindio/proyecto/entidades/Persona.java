package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS )
@MappedSuperclass
public class Persona  {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private String cedula;

    @Column ( nullable = false)
    private String contraseña;
    @Column ( nullable = false)
    private String nombre;
    @Column ( nullable = false, unique = true)
    private String email;


}

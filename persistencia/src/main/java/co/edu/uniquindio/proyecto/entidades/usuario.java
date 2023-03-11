package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.*;
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private String cedula;

    @Column ( nullable = false)
private String contraseña;
    @ManyToMany
    private List<Producto> producto;
    @ManyToMany
    private List<Producto> favoritos;





    @Column ( nullable = false)
private Estado_Cuenta estado;
    @Column ( nullable = false)

private String nombre;


    private String telefono;

    private String direccion;
    //@Column (unique = true, nullable = false)
    @Column ( nullable = false, unique = true)
    private String correo;











}

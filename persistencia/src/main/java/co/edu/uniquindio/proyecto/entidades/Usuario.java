package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Persona implements Serializable   {
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

    @OneToOne (mappedBy = "usuario")
    private Carrito carrito;





    @Column ( nullable = false)

private Boolean estado;
    @Column ( nullable = false)

private String nombre;
 @OneToMany (mappedBy = "usuario")
 private List<Comentarios> comentarios;

    @OneToMany (mappedBy = "usuario")
    private List<Compra> compra;

    private String telefono;

    private String direccion;

    @Column ( nullable = false, unique = true)
    private String correo;















}

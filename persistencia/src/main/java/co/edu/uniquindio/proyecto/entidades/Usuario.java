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
@ToString
public class Usuario implements Serializable   {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column ( nullable = false, length = 100)
    private String contraseña;
    @Column ( nullable = false, length = 100)
    private String nombre;
    @Column ( nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Producto> productos;
    @ManyToMany
    @ToString.Exclude
    private List<Producto> productosFavoritos;

    @OneToOne (mappedBy = "usuario")
    private Carrito carrito;

    @Column ( nullable = false)
    private Boolean isCuentaActiva;
    @Column ( nullable = false)
    @OneToMany (mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany (mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> compras;

    @OneToMany (mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> venta;




    @Column ( nullable = false, length = 100)
    private String telefono;

    @Column ( nullable = false, length = 100)
    private String direccion;


    public Usuario(String cedula, String contraseña, String nombre, String email,  Boolean isCuentaActiva, String telefono, String direccion) {
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.email = email;
        this.isCuentaActiva = isCuentaActiva;
        this.telefono = telefono;
        this.direccion = direccion;
    }


}

package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @ManyToMany(mappedBy = "productosFavoritos")
    @ToString.Exclude
    private List<Usuario> usuariosFavoritos;

    @Column ( nullable = false)
    private Boolean isActivo;
    @Column (nullable = false, length = 100)
    private String imagen;

    @Column ( nullable = false, length = 100)
    private String nombre;

    @Column ( nullable = false, length = 100)
    private String descripcion;
    @Column ( nullable = false)
    private Double precio;

    @Column ( nullable = false)
    private Boolean isDisponible;

    @Column ( nullable = false,length = 100)
    @Enumerated(EnumType.STRING)
    private Estado_Producto estado;
    @Column( nullable = false)
    @Future
    private LocalDateTime fechaLimite;

    @Column ( nullable = true, length = 100, name = "categoria")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @ToString.Exclude
    private Set<Categoria_Producto> categorias;
    @OneToMany (mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentario;

    @ManyToMany(mappedBy = "productos")
    @ToString.Exclude
    private List<Carrito> carritos;

    @ManyToMany (mappedBy = "productos")
    @ToString.Exclude
    private List<Compra> compras;

  public Producto( Usuario usuario,  Boolean isActivo, String imagen, String nombre, String descripcion, Double precio, Boolean isDisponible, Estado_Producto estado, LocalDateTime fechaLimite, Set<Categoria_Producto> categorias) {
      this.usuario = usuario;
    this.isActivo = isActivo;
    this.imagen = imagen;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.isDisponible = isDisponible;
    this.estado = estado;
    this.fechaLimite = fechaLimite;
    this.categorias=categorias;

  }
}

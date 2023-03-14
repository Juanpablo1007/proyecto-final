package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
  private int codigo;
    @ManyToMany (mappedBy = "producto")
    private List<Usuario> usuario;

    @ManyToMany (mappedBy = "favoritos")
    private List<Usuario> usuarioF;


    @Column( nullable = false)
    @Future
    private LocalDateTime fechaLimite;
    private String imagen;
    @Column ( nullable = false)
    private String nombre;
    @Column ( nullable = false)
    private String descripcion;
    @Column ( nullable = false)


    private String disponibilidad;
    @Column ( nullable = false)
    @Enumerated(EnumType.STRING)

   private Categorias_Producto categorias;
    @Column ( nullable = false)
   private String comentarios;
    @Column ( nullable = false)
    @Enumerated(EnumType.STRING)

   private Estado_Producto estado;

    @OneToMany (mappedBy = "producto")
    private List<Comentarios> comentario;

    @ManyToMany (mappedBy = "productos")
    private List<Carrito> carrito;
    @Column ( nullable = false)
    private Boolean isActivo;

    @Column ( nullable = false)
    private Boolean isDisponible;


}

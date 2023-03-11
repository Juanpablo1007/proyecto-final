package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @Column( nullable = false)
    private LocalDateTime fechaLimite;
    private String imagen;
    @Column ( nullable = false)
    private String nombre;
    @Column ( nullable = false)
    private String descripcion;
    @Column ( nullable = false)


    private String disponibilidad;
    @Column ( nullable = false)
   private Categorias_Producto categorias;
    @Column ( nullable = false)
   private String comentarios;
    @Column ( nullable = false)

   private Estado_Producto estado;




}

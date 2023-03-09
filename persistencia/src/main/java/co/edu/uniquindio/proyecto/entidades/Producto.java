package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private LocalDateTime fechaLimite;
    private String imagen;

    private String nombre;
    private String descripcion;

    private String disponibilidad;
   private Categorias_Producto categorias;
   private String comentarios;

   private Estado_Producto estado;




}

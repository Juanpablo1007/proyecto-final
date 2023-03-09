package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Productos_Favoritos implements Serializable {
    @Id
    //llave foranea de producto
    @EqualsAndHashCode.Include
    private int codigoProducto;
    @Id
    @EqualsAndHashCode.Include
    // llave foranea de usuario
    private String cedulaUsuario;
}

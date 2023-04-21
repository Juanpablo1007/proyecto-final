package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
// add 
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column( nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @Column (nullable = false)
    private Double total;

    @ManyToOne
    private Usuario usuario;


    @Column (nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private MetodoDePago metodoDePago;

    @ManyToMany
    @ToString.Exclude
    private List<Producto> productos;

}

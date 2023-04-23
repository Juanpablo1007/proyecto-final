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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @ToString.Exclude
    private Producto producto;

    @Column (nullable = false)
    private Integer unidadesCompradas;

    public Compra(LocalDateTime fecha, Double total, Usuario usuario, MetodoDePago metodoDePago, Producto producto, Integer unidadesCompradas) {
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.metodoDePago = metodoDePago;
        this.producto = producto;
        this.unidadesCompradas = unidadesCompradas;
    }
}

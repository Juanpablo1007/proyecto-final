package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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
    @PositiveOrZero
    private Double total;

    @ManyToOne
    @NotNull
    private Usuario usuario;


    @Column (nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private MetodoDePago metodoDePago;

    @ManyToOne
    @NotNull
    private Producto producto;

    @Column (nullable = false)
    @Min(value = 1, message = "Se debe vender minimamente una unidad del producto")
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

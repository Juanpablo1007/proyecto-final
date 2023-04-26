package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {


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
    @ToString.Exclude
    private Producto producto;

    @Column (nullable = false)
    @Min(value = 1, message = "Se debe vender minimamente una unidad del producto") //validar que maximo sea producto.getUnidades();
    private Integer unidadesVendidas;


    public Venta(LocalDateTime fecha, Double total, Usuario usuario, MetodoDePago metodoDePago, Producto producto, Integer unidadesVendidas) {
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.metodoDePago = metodoDePago;
        this.producto = producto;
        this.unidadesVendidas = unidadesVendidas;
    }
}

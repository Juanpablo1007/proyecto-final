package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.MetodoDePago;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompraPostDTO {

    private String usuarioCedula;
    private Integer productoCodigo;

    @NotNull(message = "La compra debe tener un metodo de pago")
    private MetodoDePago metodoDePago;
    @Min(value = 1, message = "Se debe comprar al menos una unidad del producto")
    private Integer unidadesCompradas;
    @PositiveOrZero
    private Double total;

}

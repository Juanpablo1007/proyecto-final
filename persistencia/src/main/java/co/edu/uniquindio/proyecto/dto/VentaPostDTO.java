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
public class VentaPostDTO {

    private String usuarioCedula;
    private Integer productoCodigo;
    @NotNull(message = "La venta debe tener un metodo de pago")
    private MetodoDePago metodoDePago;
    @Min(value = 1, message = "Una venta debe tener al menos una unidad vendida")
    private Integer unidadesVendidas;
    @PositiveOrZero
    private Double total;

}

package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.CarritoProductos;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;


import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarritoGetDto {

    private Integer codigo;

    private List<CarritoProductos> productos;

    private Usuario usuario;
}

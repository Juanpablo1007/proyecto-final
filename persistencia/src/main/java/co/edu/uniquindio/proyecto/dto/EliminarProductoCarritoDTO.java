package co.edu.uniquindio.proyecto.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EliminarProductoCarritoDTO {

    @NotEmpty(message = "La cedula del usuario propietario del carrito no puede estar vacia")
    String usuarioCedulaCarrito;
    @NotEmpty(message = "El codigo del producto que quiere agregar al carrito no puede estar vacio")
    Integer productoCodigo;

}

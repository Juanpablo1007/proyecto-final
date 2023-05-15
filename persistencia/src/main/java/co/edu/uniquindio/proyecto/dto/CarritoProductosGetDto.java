package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Carrito;
import co.edu.uniquindio.proyecto.entidades.CarritoProductosLlave;
import co.edu.uniquindio.proyecto.entidades.Producto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarritoProductosGetDto {
    CarritoProductosLlave id = new CarritoProductosLlave();
    Carrito carrito;
    Producto producto;
    Integer unidades;




}

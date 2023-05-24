package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Carrito;
import co.edu.uniquindio.proyecto.entidades.CarritoProductos;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import lombok.*;


import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarritoGetDTO {

    private String usuarioCedula;
    private List<CarritoProductosGetDTO> productos;
    private Double total;

    public CarritoGetDTO(String usuarioCedula, Double total, List<CarritoProductos> productos) {
        this.usuarioCedula = usuarioCedula;
        List<CarritoProductosGetDTO> productosGetDTOS = new ArrayList<>();
        for (CarritoProductos producto: productos) {
            Producto productoDeCarrito = producto.getProducto();
            ProductoGetDTO productoGetDTO = new ProductoGetDTO(productoDeCarrito.getCodigo(),productoDeCarrito.getUsuario().getCedula(),productoDeCarrito.getUsuario().getNombre(),productoDeCarrito.getUsuariosFavoritos().size(),productoDeCarrito.getIsActivo(),productoDeCarrito.getImagen(),productoDeCarrito.getNombre(),productoDeCarrito.getDescripcion(),productoDeCarrito.getPrecio(),productoDeCarrito.getUnidades(),productoDeCarrito.getEstado(),productoDeCarrito.getCategorias(),productoDeCarrito.getIsDisponible(),productoDeCarrito.getFechaLimite(),productoDeCarrito.getComentario());
            CarritoProductosGetDTO productosGetDTO = new CarritoProductosGetDTO(productoGetDTO,producto.getUnidades());
            productosGetDTOS.add(productosGetDTO);
        }
        this.productos = productosGetDTOS;
        this.total = total;
    }
}

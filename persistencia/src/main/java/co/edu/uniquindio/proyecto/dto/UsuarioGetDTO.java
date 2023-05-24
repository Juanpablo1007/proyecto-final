package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioGetDTO {
    private String cedula;
    private String nombre;
    private String email;
    private List<ProductoGetDTO> productos;
    private List<ProductoGetDTO> productosFavoritos;
    private CarritoGetDTO carrito;
    private Boolean isCuentaActiva;
    private List<ComentarioGetDTO> comentarios;
    private List<CompraGetDTO> compras;
    private List<VentaGetDTO> ventas;
    private String telefono;
    private String direccion;

    public UsuarioGetDTO(String cedula, String nombre, String email, CarritoGetDTO carrito, Boolean isCuentaActiva, String telefono, String direccion, List<Producto>productos,List<Producto> productosFavoritos, List<Comentario> comentarios,List<Venta> ventas,List<Compra> compras) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.carrito = carrito;
        this.isCuentaActiva = isCuentaActiva;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}

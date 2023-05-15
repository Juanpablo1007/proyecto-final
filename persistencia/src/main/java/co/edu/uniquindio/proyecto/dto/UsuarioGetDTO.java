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



    private String contraseña;

    private String nombre;

    private String email;


    private List<Producto> productos;

    private List<Producto> productosFavoritos;


    private Carrito carrito;


    private Boolean isCuentaActiva;


    private List<Comentario> comentarios;


    private List<Compra> compras;


    private List<Venta> ventas;



    private String telefono;


    private String direccion;

}

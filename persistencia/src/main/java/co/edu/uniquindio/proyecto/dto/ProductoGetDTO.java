package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoGetDTO {
    private Integer codigo;
    private Usuario usuario;
    private List<Usuario> usuariosFavoritos;
    private Boolean isActivo;
    private String imagen;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer unidades;
    private Estado_Producto estado;
    private Set<Categoria_Producto> categorias;
    private List<Comentario> comentario;
    private List<CarritoProductos> carritos;
    private List<Compra> compras;
    private List<Venta> ventas;
}

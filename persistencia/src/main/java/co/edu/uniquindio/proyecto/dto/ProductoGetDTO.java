package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoGetDTO {

    private Integer codigo;
    private String usuarioCedula;
    private String usuarioNombre;
    private Integer numeroFavoritos;
    private Boolean isActivo;
    private String imagen;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer unidades;
    private Estado_Producto estado;
    private Set<Categoria_Producto> categorias = new HashSet<>();
    private List<ComentarioGetDTO> comentarios= new ArrayList<>();
    private Boolean isDisponible;
    private LocalDateTime fechaLimite;

    public ProductoGetDTO(Integer codigo, String usuarioCedula, String usuarioNombre, Integer numeroFavoritos, Boolean isActivo, String imagen, String nombre, String descripcion, Double precio, Integer unidades, Estado_Producto estado, Set<Categoria_Producto> categorias, Boolean isDisponible, LocalDateTime fechaLimite, List<Comentario> comentarios) {
        this.codigo = codigo;
        this.usuarioCedula = usuarioCedula;
        this.usuarioNombre = usuarioNombre;
        this.numeroFavoritos = numeroFavoritos;
        this.isActivo = isActivo;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.estado = estado;
        this.categorias = categorias;
        this.isDisponible = isDisponible;
        this.fechaLimite = fechaLimite;
        List<ComentarioGetDTO> comentarioGetDTOS = new ArrayList<>();
        for (Comentario comentario: comentarios
        ) {
            ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(comentario.getTexto(),comentario.getFecha(),comentario.getUsuario().getCedula(),comentario.getProducto().getCodigo());
            comentarioGetDTOS.add(comentarioGetDTO);
        }
        this.comentarios=comentarioGetDTOS;
    }
}

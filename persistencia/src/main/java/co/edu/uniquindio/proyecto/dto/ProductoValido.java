package co.edu.uniquindio.proyecto.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProductoValido {
    private String nombre;
    private String descripcion;
    private Double precio;

    public ProductoValido(String nombre,String descripcion,Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}

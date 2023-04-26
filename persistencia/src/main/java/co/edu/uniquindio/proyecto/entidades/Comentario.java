package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column( nullable = false, length = 1000)
    @NotBlank(message = "El comentario necesita texto")
    private String texto;
    @Column( nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @ManyToOne
    @NotNull
    private Usuario usuario;

    @ManyToOne
    @NotNull
    private Producto producto;

    public Comentario(String texto, LocalDateTime fecha, Usuario usuario, Producto producto) {
        this.texto = texto;
        this.fecha = fecha;
        this.usuario = usuario;
        this.producto = producto;
    }
}


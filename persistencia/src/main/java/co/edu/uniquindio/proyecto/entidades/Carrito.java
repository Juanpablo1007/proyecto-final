package co.edu.uniquindio.proyecto.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Carrito implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @ManyToMany
    @ToString.Exclude
    private List <Producto> productos;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Carrito(Usuario usuario) {
        this.usuario = usuario;
    }
}

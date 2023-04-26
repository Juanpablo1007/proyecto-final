package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.time.LocalDateTime.now;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    public void subirProductoTest() {
        Usuario usuario = new Usuario("1001017577","Juan123","Juan Pablo","juanp.delgadod@uqvirutal.edu.co",true,"3218711230","Reserva de la pastorita");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        Producto producto = new Producto(usuario, true, "imagen", "Nintendo", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(0);
        Carrito carrito = new Carrito(usuario);
        try {
            Usuario u = usuarioServicio.registrarUsuario(usuario);
            Producto p = productoServicio.publicarProducto(producto);
            System.out.println(p.getCodigo());
            Assertions.assertNotNull(p);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertNotNull(null);
        }
    }


}

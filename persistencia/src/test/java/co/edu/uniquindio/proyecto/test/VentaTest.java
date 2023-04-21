package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.MetodoDePago;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.Venta;
import co.edu.uniquindio.proyecto.repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VentaTest {


    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ProductoRepo productoRepo;

     @Test
    public void registrarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);

        Producto producto=  productoRepo.findById(123).orElse(null);

         List<Producto> productosventa= new ArrayList<>();

        productosventa.add(producto);

        Venta venta = new Venta();
        venta.setCodigo(12345);
        venta.setUsuario(usuario);
        venta.setProductos(productosventa);
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(20000.0);
        venta.setMetodoDePago(MetodoDePago.EFECTIVO);

        Venta ventaGenerada = ventaRepo.save(venta);
        Assertions.assertNotNull(ventaGenerada);

    }

    public void ereminarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);

        Producto producto=  productoRepo.findById(123).orElse(null);

        List<Producto> productosventa= new ArrayList<>();

        productosventa.add(producto);

        Venta venta = new Venta();
        venta.setCodigo(12345);
        venta.setUsuario(usuario);
        venta.setProductos(productosventa);
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(20000.0);
        venta.setMetodoDePago(MetodoDePago.EFECTIVO);

        Venta ventaGenerada = ventaRepo.save(venta);
        Assertions.assertNotNull(ventaGenerada);

    }

}

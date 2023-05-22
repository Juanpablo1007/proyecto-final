package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.servicios.*;

import co.edu.uniquindio.proyecto.entidades.*;

import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.*;

import static java.time.LocalDateTime.now;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class VentaServicioTest {


    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private VentaServicio ventaServicio;

    @Autowired
    private CarritoServicio carritoServicio;
    @Test
    public void registrarVenta() throws Exception  {
        Usuario usuario = new Usuario("1001017577","Juan123","Juan Pablo","juanp.delgadod@uqvirutal.edu.co",true,"3218711230","Reserva de la pastorita");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        List<CarritoProductos> productosCarrito = new ArrayList<CarritoProductos>();
        Carrito carrito = new Carrito();

        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        Producto producto2 = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);

        try {
            Usuario u = usuarioServicio.registrarUsuario(usuario);
            Producto p = productoServicio.publicarProducto(producto,u);
            Producto p2 = productoServicio.publicarProducto(producto2,u);
            Carrito c = carritoServicio.asignarCarrito(carrito,u.getCedula());

            carritoServicio.agregarProducto(p.getCodigo(),c.getCodigo(),3);
            carritoServicio.agregarProducto(p2.getCodigo(),c.getCodigo(),5);


            for (CarritoProductos productoCarro: u.getCarrito().getProductos()) {
                Venta venta  = new Venta(LocalDateTime.now(),0.0,u,MetodoDePago.EFECTIVO,productoCarro.getProducto(),productoCarro.getUnidades());

                Venta ventaRegistrada = ventaServicio.realizarVenta(venta,u,p);
                System.out.println(ventaRegistrada);
            }
            System.out.println(u.getVentas());
            System.out.println(p.getVentas());
            Assertions.assertEquals(2,u.getVentas().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertNotNull(null);
        }
    }





}


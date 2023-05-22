package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.CarritoServicio;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CompraServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private CarritoServicio carritoServicio;



    @Test
    public void registrarCompra() throws Exception  {
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
                Compra compra = new Compra(LocalDateTime.now(),0.0,u,MetodoDePago.EFECTIVO,productoCarro.getProducto(),productoCarro.getUnidades());
                Compra compraRegistrada = compraServicio.realizarCompra(compra, u, productoCarro.getProducto());
                System.out.println(compraRegistrada);
            }
            System.out.println(u.getCompras());
            System.out.println(p.getCompras());
            System.out.println(p2.getCompras());
            Assertions.assertEquals(2,u.getCompras().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertNotNull(null);
        }
    }

    @Test
    public void listarComprasDeUsuario() throws Exception  {
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
                Compra compra = new Compra(LocalDateTime.now(),0.0,u,MetodoDePago.EFECTIVO,productoCarro.getProducto(),productoCarro.getUnidades());
                Compra compraRegistrada = compraServicio.realizarCompra(compra, u, productoCarro.getProducto());
                System.out.println(compraRegistrada);
            }

            List<Compra> comprasUsuario = compraServicio.listarComprasDeUsuario(u);

            Assertions.assertEquals(2,comprasUsuario.size());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertNotNull(null);
        }
    }

}

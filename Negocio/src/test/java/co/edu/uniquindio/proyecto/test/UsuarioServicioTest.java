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
import java.util.*;

import static java.time.LocalDateTime.now;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional

public class UsuarioServicioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    public void registrarUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");


        try {
            Usuario usuario1 = usuarioServicio.registrarUsuario(usuario);
            Assertions.assertNotNull(usuario1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void EliminarUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        try {
            Usuario usuario1 = usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.EliminarUsuario(usuario.getCedula());
            Assertions.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }

    @Test
    public void ActualizarUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        try {
            usuarioServicio.registrarUsuario(usuario);
            usuario.setTelefono("3218711254");
            Usuario u = usuarioServicio.ActualizarUsuario(usuario);

            Assertions.assertNotNull(u);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }

    @Test
    public void listararUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Usuario usuario2 = new Usuario();
        usuario2.setCedula("1011007775");
        usuario2.setEmail("didier.ortegar@uqvirtual.edu.co");
        usuario2.setContraseña("Juan123");
        usuario2.setIsCuentaActiva(true);
        usuario2.setTelefono("3218711230");
        usuario2.setDireccion("Reserva de la pastorita");
        usuario2.setNombre("Didier");


        try {
            usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.registrarUsuario(usuario2);


            List<Usuario> lista = usuarioServicio.listarUsuario();
            lista.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }

    @Test
    public void loguearUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");


        try {
            usuarioServicio.registrarUsuario(usuario);
            Optional<Usuario> u = usuarioServicio.logUsuario(usuario.getEmail(), usuario.getContraseña());

            Assertions.assertNotNull(u);


        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }


    @Test
    public void listarProductoPreciosTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "Nintendo", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        Producto producto2 = new Producto(usuario, true, "imagen", "Nintendo", "Consola nintendo", 5000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto2.setCodigo(2);
        try {
            usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.publicarProducto(producto);
            usuarioServicio.publicarProducto(producto2);
            List<Producto> lista = usuarioServicio.listarProductoPrecio(7000.0, 3000.0);
            lista.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarProductoTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        Producto producto2 = new Producto(usuario, true, "imagen", "play 4", "Consola nintendo", 5000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto2.setCodigo(2);
        try {
            usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.publicarProducto(producto);
            usuarioServicio.publicarProducto(producto2);
            List<Producto> lista = usuarioServicio.listarProductosPublicados();
            lista.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void listarProductoNombreTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        Producto producto2 = new Producto(usuario, true, "imagen", "play 4", "Consola nintendo", 5000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto2.setCodigo(2);
        try {
            usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.publicarProducto(producto);
            usuarioServicio.publicarProducto(producto2);
            List<Producto> lista = usuarioServicio.buscarProductoNombre("play");
            lista.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void registrarCompra() throws Exception {
     /**   Usuario usuario = new Usuario("1001017577","Juan123","Juan Pablo","juanp.delgadod@uqvirutal.edu.co",true,"3218711230","Reserva de la pastorita");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        List<Producto> productosCarrito = new ArrayList<Producto>();


        try {
           Usuario u = usuarioServicio.registrarUsuario(usuario);

           Carrito carrito = new Carrito(u);


           Producto producto = new Producto(u, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
           Producto producto2 = new Producto(u, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
           Producto p = productoServicio.publicarProducto(producto);
           Producto p2 = productoServicio.publicarProducto(producto2);

           productosCarrito.add(p);
           productosCarrito.add(p2);
           carrito.setProductos(productosCarrito);
           Carrito c = usuarioServicio.asignarCarrito(carrito);

           System.out.println(u.getProductos());

           Integer unidadesCompradas = 3;
           int i =0;
            for (Producto productoCarro: c.getProductos()) {
                Compra compra = new Compra(LocalDateTime.now(),0.0,u,MetodoDePago.EFECTIVO,productoCarro,unidadesCompradas);
                Compra compraRegistrada = usuarioServicio.registrarCompra(u, productoCarro, compra);
                Long total = usuarioServicio.calcularTotal(compraRegistrada.getCodigo());
                compraRegistrada.setTotal((double)total);
                Compra def = usuarioServicio.ActualizarCompra(compraRegistrada);
                System.out.println(def);
                i++;
            }
            Assertions.assertEquals(2,i);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertNotNull(null);
        }
**/
    }

    @Test
    public void listarCompras() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        try {
            Usuario u = usuarioServicio.registrarUsuario(usuario);
            Producto p = usuarioServicio.publicarProducto(producto);
            Set<MetodoDePago> metodoDePagos = new HashSet<MetodoDePago>();
            metodoDePagos.add(MetodoDePago.EFECTIVO);
            metodoDePagos.add(MetodoDePago.TARJETA_DE_CREDITO);
            metodoDePagos.add(MetodoDePago.TRANSACCION_BANCARIA);

            Compra compra = new Compra();
            compra.setUsuario(usuario);
            compra.setCodigo(1);
            compra.setTotal(0.0);
            compra.setProducto(producto);
            compra.setUnidadesCompradas(25);
            compra.setFecha(now());
            compra.setMetodoDePago(MetodoDePago.EFECTIVO);

            Compra c = usuarioServicio.registrarCompra(u, p, compra);
            Long total = usuarioServicio.calcularTotal(c.getCodigo());
            c.setTotal((double)total);
            Compra def = usuarioServicio.ActualizarCompra(c);
            List<Compra> lista = usuarioServicio.listarCompras(usuario);
            lista.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void ListarVenta() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        try {
            Usuario u = usuarioServicio.registrarUsuario(usuario);
            Producto p = usuarioServicio.publicarProducto(producto);
            Set<MetodoDePago> metodoDePagos = new HashSet<MetodoDePago>();
            metodoDePagos.add(MetodoDePago.EFECTIVO);
            metodoDePagos.add(MetodoDePago.TARJETA_DE_CREDITO);
            metodoDePagos.add(MetodoDePago.TRANSACCION_BANCARIA);

            Venta venta = new Venta();
            venta.setCodigo(1);
            venta.setFecha(now());
            venta.setUsuario(usuario);
            venta.setMetodoDePago(MetodoDePago.EFECTIVO);
            venta.setTotal(0.0);
            venta.setUnidadesVendidas(25);
            venta.setProducto(producto);

            Venta v = usuarioServicio.registrarVenta(u,p,venta);
            Long total = usuarioServicio.calcularTotalVenta(v.getUsuario().getCedula());
            System.out.println(total);
            v.setTotal((double) total);
            Venta def = usuarioServicio.ActualizarVenta(v);

            List<Venta> lista = usuarioServicio.listarVenta(usuario);
            lista.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void registrarVenta() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "play 5", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(1);


        try {
            Usuario u = usuarioServicio.registrarUsuario(usuario);
            Producto p = usuarioServicio.publicarProducto(producto);
            Set<MetodoDePago> metodoDePagos = new HashSet<MetodoDePago>();
            metodoDePagos.add(MetodoDePago.EFECTIVO);
            metodoDePagos.add(MetodoDePago.TARJETA_DE_CREDITO);
            metodoDePagos.add(MetodoDePago.TRANSACCION_BANCARIA);

           Venta venta = new Venta();
          venta.setCodigo(1);
            venta.setFecha(now());
            venta.setUsuario(usuario);
            venta.setMetodoDePago(MetodoDePago.EFECTIVO);
            venta.setTotal(0.0);
            venta.setUnidadesVendidas(25);
            venta.setProducto(producto);

            Venta v = usuarioServicio.registrarVenta(u,p,venta);
            Long total = usuarioServicio.calcularTotalVenta(v.getUsuario().getCedula());
            System.out.println(total);
            v.setTotal((double) total);
            Venta def = usuarioServicio.ActualizarVenta(v);

            Assertions.assertNotNull(v);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void actualizarProductoTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "Nintendo", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(0);
        try {
            usuarioServicio.registrarUsuario(usuario);
            Producto p = usuarioServicio.publicarProducto(producto);
            System.out.println( "Anterior" + p);
            producto.setNombre("play 3");
            producto.setDescripcion("ahora es un play 3");
            Producto p2 = usuarioServicio.ActualizarProducto(producto);
            System.out.println("Actualizado" + p2  );
            Assertions.assertNotNull(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } @Test
    public void EliminarProductoTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario, true, "imagen", "Nintendo", "Consola nintendo", 3000.0, true, Estado_Producto.SIN_REVISAR, now().plusMonths(5), categorias, 30);
        producto.setCodigo(0);

        try {
            Usuario usuario1 = usuarioServicio.registrarUsuario(usuario);
            Producto producto1 = usuarioServicio.publicarProducto(producto);
            usuarioServicio.EliminarProducto(producto1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }

}

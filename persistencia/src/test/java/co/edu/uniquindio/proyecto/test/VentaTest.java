package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.jdbc.Sql;

import javax.swing.text.html.Option;
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
    @Sql("classpath:ventas.sql")
    public void registrarTest() {

        Usuario usuario= usuarioRepo.findById("1004870909").orElse(null);

        Producto producto=  productoRepo.findById(1).orElse(null);

        int unidadesVendidas = 2;

        Venta venta = new Venta(LocalDateTime.now(),producto.getPrecio()*unidadesVendidas,usuario,MetodoDePago.TARJETA_DE_CREDITO,producto,unidadesVendidas);

        Venta ventaGenerada = ventaRepo.save(venta);

        Assertions.assertNotNull(ventaGenerada);

    }
    @Test
    @Sql("classpath:ventas.sql")
    public void eliminarTest() {


        Venta ventaGenerada = ventaRepo.findById(1).orElse(null);

        ventaRepo.delete(ventaGenerada);

        Venta busquedaVenta = ventaRepo.findById(1).orElse(null);

        Assertions.assertNull(busquedaVenta);

    }

    @Test
    @Sql("classpath:ventas.sql")
    public void actualizarTest() {

        Venta ventaGenerada = ventaRepo.findById(1).orElse(null);
        ventaGenerada.setMetodoDePago(MetodoDePago.TRANSACCION_BANCARIA);
        ventaRepo.save(ventaGenerada);
        Venta busquedaventa = ventaRepo.findById(1).orElse(null);
        Assertions.assertEquals(MetodoDePago.TRANSACCION_BANCARIA, busquedaventa.getMetodoDePago());

    }
    @Test
    @Sql("classpath:ventas.sql")
        public void ListarTest() {

        List<Venta> lista = ventaRepo.findAll();

        lista.forEach(System.out::println);

        }

    @Test
    @Sql("classpath:ventas.sql")
    public void buscarPorFechasAnteriores() {

        List<Venta> lista = ventaRepo.findAllByFechaBefore(LocalDateTime.now());

        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:ventas.sql")
    public void buscarPorNombreDeUsuario() {

        List<Venta> lista = ventaRepo.findAllByUsuario_Nombre("Pedro");

        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:ventas.sql")
    public void buscarPorIdDeProducto() {

           List<Venta> lista = ventaRepo.findAllByProducto_Codigo(3);

           lista.forEach(System.out::println);
        }
    @Test
    @Sql("classpath:Ventas.sql")
    public void ListarProductosCompradosPorUsuario() {

        List<Producto> lista = ventaRepo.obtenerListaProductosVendidos("1004870909");

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Ventas.sql")
    public void calcularTotalVentas() {


        Long ventas = ventaRepo.calcularTotalVentas("1004399032");
    System.out.println(ventas);
    }


    }


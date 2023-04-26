package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:compras.sql")
    public void registrarTest() {

        Usuario usuario= usuarioRepo.findById("1004870909").orElse(null);

        Producto producto=  productoRepo.findById(1).orElse(null);

        int unidadesVendidas = 2;

        Compra compra = new Compra(LocalDateTime.now(),producto.getPrecio()*unidadesVendidas,usuario,MetodoDePago.TARJETA_DE_CREDITO,producto,unidadesVendidas);

        Compra compraGenerada = compraRepo.save(compra);

        Assertions.assertNotNull(compraGenerada);

    }
    @Test
    @Sql("classpath:compras.sql")
    public void eliminarTest() {


        Compra compraGenerada = compraRepo.findById(1).orElse(null);

        compraRepo.delete(compraGenerada);

        Compra busquedaCompra = compraRepo.findById(1).orElse(null);

        Assertions.assertNull(busquedaCompra);

    }

    @Test
    @Sql("classpath:compras.sql")
    public void actualizarTest() {

        Compra compraGenerada = compraRepo.findById(1).orElse(null);
        compraGenerada.setMetodoDePago(MetodoDePago.TRANSACCION_BANCARIA);
        compraRepo.save(compraGenerada);
        Compra busquedaCompra = compraRepo.findById(1).orElse(null);
        Assertions.assertEquals(MetodoDePago.TRANSACCION_BANCARIA, busquedaCompra.getMetodoDePago());

    }
    @Test
    @Sql("classpath:compras.sql")
    public void ListarTest() {

        List<Compra> lista = compraRepo.findAll();

        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:compras.sql")
    public void buscarPorFechasAnteriores() {

        List<Compra> lista = compraRepo.findAllByFechaBefore(LocalDateTime.now());

        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:compras.sql")
    public void buscarPorNombreDeUsuario() {

        List<Compra> lista = compraRepo.findAllByUsuario_Nombre("Pedro");

        lista.forEach(System.out::println);

    }
    @Test
    @Sql("classpath:compras.sql")
    public void buscarPorCedulaDeUsuario() {

        List<Compra> lista = compraRepo.findAllByUsuario_Cedula("1004870909");

        lista.forEach(System.out::println);

    }
    @Test
    @Sql("classpath:compras.sql")
    public void buscarPorIdDeProducto() {

        List<Compra> lista = compraRepo.findAllByProducto_Codigo(3);

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:compras.sql")
    public void ListarProductosCompradosPorUsuario() {

        List<Producto> lista = compraRepo.obtenerListaProductosComprados("1004870909");

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:compras.sql")
    public void ListarCantidadProductosCompradosPorUsuario() {

        Long total = compraRepo.obtenerListaProductosCompradosSinRepetir("1004870909");

       System.out.println(total);
    }
    @Test
    @Sql("classpath:Compras.sql")
    public void calcularTotalVentas() {


        Long compras = compraRepo.calcularTotalCompras(3);
        System.out.println(compras);
    }

}

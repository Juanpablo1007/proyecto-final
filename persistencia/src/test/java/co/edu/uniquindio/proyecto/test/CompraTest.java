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
    public void registrarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);

        Producto producto=  productoRepo.findById(123).orElse(null);

        List<Producto> productoscompra= new ArrayList<>();

        productoscompra.add(producto);

       Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setCodigo(1);
        compra.setFecha(LocalDateTime.now());
        compra.setTotal(20000.0);
        compra.setProductos(productoscompra);
        compra.setMetodoDePago(MetodoDePago.TRANSSACCION_BANCARIA);

        Compra compraGenerada = compraRepo.save(compra);
        Assertions.assertNotNull(compraGenerada);

    }


}

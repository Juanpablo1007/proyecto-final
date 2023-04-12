package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {


    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;
    private Carrito carrito = null;

    @Test
    @Sql("classpath:productos.sql")
    public void registrarTest(){

        Usuario usuario= usuarioRepo.findById("123").orElse(null);
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);

        Producto producto = new Producto( usuario, true, "url", "martillo", "es un martillo",
                20000.0, true, Estado_Producto.AUTORIZADO,
                 LocalDateTime.now().plusMonths(2),categorias);

        Producto   productoGuardado = productoRepo.save(producto);
       Assertions.assertNotNull(productoGuardado);

    }
    
    
    
}

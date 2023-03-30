package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {


    @Autowired
    private ProductoRepo productoRepo;
    private Carrito carrito = null;
   private Usuario usuario= new Usuario("1001017577","123","juan",
           "yutu", carrito, true, "3218711230",
           "reserva de la pastorita" );
    @Test


    public void registrarTest(){

        Producto producto = new Producto( usuario, true, "url", "martillo", "es un martillo",
                20000.0, true, Estado_Producto.AUTORIZADO,
                 LocalDateTime.now());
     producto.setCategorias(Categoria_Producto.BEBES);

        Producto   productoGuardado = productoRepo.save(producto);
       Assertions.assertNotNull(productoGuardado);

    }
    
    
    
}

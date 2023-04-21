package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CarritoTest {

    @Autowired
    private CarritoRepo carritoRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;



   // @Test






}

package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.Venta;
import co.edu.uniquindio.proyecto.repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VentaTest {


    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ProductoRepo productoRepo;


    /**public void registrarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);
     List  <Producto> producto=  productoRepo.findById(123).orElse(null);
        Venta venta = new Venta();
        venta.setUsuario(usuario);
       // venta.setProductos();
        venta.setFecha();
        venta.setTotal(20000.0);
        venta.setMetodoDePago();

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }**/

}

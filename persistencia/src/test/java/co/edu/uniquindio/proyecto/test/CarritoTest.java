package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria_Producto;
import co.edu.uniquindio.proyecto.entidades.Estado_Producto;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CarritoTest {

    @Autowired
    private CarritoRepo carritoRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;




  public void registrarTest() {
       Usuario usuario= usuarioRepo.findById("123").orElse(null);
       Usuario usuario = new Usuario("1001017578", "1234", "juan david", "yutud1@hotmail.com", true, "3218711230", "reserva");

       //Producto producto=  productoRepo.findById(1234).orElse(null);



       Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
       categorias.add(Categoria_Producto.BEBES);
       categorias.add(Categoria_Producto.CONSTRUCCION);
       categorias.add(Categoria_Producto.HERRAMIENTAS);

       Producto producto = new Producto();
       producto.setCodigo(123);
       producto.setUsuario(usuario);
       producto.setImagen("url.png");
       producto.setNombre("martillo");
       producto.setDescripcion("es un martillo");
       producto.setPrecio(20000.0);
       producto.setIsDisponible(true);
       producto.setEstado(Estado_Producto.AUTORIZADO);
       producto.setFechaLimite(LocalDateTime.now().plusMonths(2));
       producto.setCategorias(categorias);



       Producto   productoGuardado = productoRepo.save(producto);



**/




   }








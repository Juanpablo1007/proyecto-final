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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
       Assertions.assertNotNull(productoGuardado);

    }

    @Test
    public void eliminarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);

        Producto producto = new Producto();
        producto.setCodigo(1234);
        producto.setUsuario(usuario);
        producto.setImagen("imagen/url");
        producto.setNombre("destronillador");
        producto.setDescripcion("es un destornillador ");
        producto.setPrecio(24000.0);
        producto.setIsDisponible(true);
        producto.setEstado(Estado_Producto.AUTORIZADO);
        producto.setFechaLimite(LocalDateTime.now().plusMonths(2));
        producto.setCategorias(categorias);


        productoRepo.delete(producto);
        Producto buscado = productoRepo.findById(123).orElse(null);
        Assertions.assertNull(buscado);

    }

    @Test
    public void actualizarTest() {
        Usuario usuario= usuarioRepo.findById("123").orElse(null);
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);

        Producto producto = new Producto();
        producto.setCodigo(1234);
        producto.setUsuario(usuario);
        producto.setImagen("imagen/url");
        producto.setNombre("destronillador");
        producto.setDescripcion("es un destornillador ");
        producto.setPrecio(24000.0);
        producto.setIsDisponible(true);
        producto.setEstado(Estado_Producto.AUTORIZADO);
        producto.setFechaLimite(LocalDateTime.now().plusMonths(2));
        producto.setCategorias(categorias);

        Producto productoGuardado = productoRepo.save(producto);

       productoGuardado.setDescripcion("Es una destornillador de clase A");
        productoRepo.save(productoGuardado);
        Producto buscado = productoRepo.findById(1234).orElse(null);
        Assertions.assertEquals(1234, buscado.getCodigo());


    }

    @Test
    public void listarTest() {
        Usuario usuario= usuarioRepo.findById("123").orElse(null);
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);

        Producto producto = new Producto();
        producto.setCodigo(1234);
        producto.setUsuario(usuario);
        producto.setImagen("imagen/url");
        producto.setNombre("destronillador");
        producto.setDescripcion("es un destornillador ");
        producto.setPrecio(24000.0);
        producto.setIsDisponible(true);
        producto.setEstado(Estado_Producto.AUTORIZADO);
        producto.setFechaLimite(LocalDateTime.now().plusMonths(2));
        producto.setCategorias(categorias);

        Producto productoGuardado = productoRepo.save(producto);


        List<Producto> lista = new ArrayList<>();
        lista.add(productoGuardado);
        lista = productoRepo.findAll();

        System.out.println(lista);
    }
    @Test
    @Sql("classpath:productos.sql")
    public void MostrarComentarios(){

        List<Comentario> comentarios = productoRepo.obtenerComentarios(124);
        comentarios.forEach(System.out::println);
        Assertions.assertEquals(1, comentarios.size());
    }
    
    
}

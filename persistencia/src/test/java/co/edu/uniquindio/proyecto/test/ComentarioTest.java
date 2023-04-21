package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.VentaRepo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {



    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Test

    public void registrarTest() {


        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

    //     usuarioRepo.saveAndFlush(usuario);


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



         productoRepo.save(producto);


        Comentario comentario = new Comentario();
        comentario.setCodigo(1);
        comentario.setUsuario(usuario);
        comentario.setFecha(LocalDateTime.now());
        comentario.setProducto(producto);
        comentario.setTexto("buen producto 10 de 10");



        Comentario comentarioGenerado = comentarioRepo.save(comentario);
        Assertions.assertNotNull(comentarioGenerado);

    }


    /**@Test
    public void EliminarTest() {

        Usuario usuario= usuarioRepo.findById("123").orElse(null);

        Producto producto=  productoRepo.findById(123).orElse(null);



        Comentario comentario = new Comentario();
        comentario.setUsuario(usuario);
        comentario.setCodigo(1);
        comentario.setFecha(LocalDateTime.now());
        comentario.setProducto(producto);
        comentario.setTexto("buen producto 10 de 10");



        Comentario compraGenerada = comentarioRepo.save(comentario);
        Assertions.assertNotNull(compraGenerada);

    }**/



}

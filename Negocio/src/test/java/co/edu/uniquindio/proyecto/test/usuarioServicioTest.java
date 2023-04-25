package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Categoria_Producto;
import co.edu.uniquindio.proyecto.entidades.Estado_Producto;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional

public class usuarioServicioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    public void registrarUsuarioTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

try{
    Usuario usuario1 = usuarioServicio.registrarUsuario(usuario);
    Assertions.assertNotNull(usuario1);
}
 catch (Exception e){
   e.printStackTrace();
 }
    }
    @Test
    public void EliminarUsuarioTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        try{
            Usuario usuario1 = usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.EliminarUsuario(usuario.getCedula());
            Assertions.assertTrue(true);
        }
        catch (Exception e){
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }
    @Test
    public void ActualizarUsuarioTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        try{
             usuarioServicio.registrarUsuario(usuario);
            usuario.setTelefono("3218711254");
            Usuario u =    usuarioServicio.ActualizarUsuario(usuario);

            Assertions.assertNotNull(u);
        }
        catch (Exception e){
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }

    @Test
    public void listararUsuarioTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Usuario usuario2 = new Usuario();
        usuario2.setCedula("1011007775");
        usuario2.setEmail("didier.ortegar@uqvirtual.edu.co");
        usuario2.setContraseña("Juan123");
        usuario2.setIsCuentaActiva(true);
        usuario2.setTelefono("3218711230");
        usuario2.setDireccion("Reserva de la pastorita");
        usuario2.setNombre("Didier");


        try{
            usuarioServicio.registrarUsuario(usuario);
            usuarioServicio.registrarUsuario(usuario2);


            List <Usuario> lista = usuarioServicio.listarUsuario();
lista.forEach(System.out:: println );

        }
        catch (Exception e){
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }
    @Test
    public void loguearUsuarioTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");



        try{
            usuarioServicio.registrarUsuario(usuario);
            Optional<Usuario> u = usuarioServicio.logUsuario(usuario.getEmail(), usuario.getContraseña());

            Assertions.assertNotNull(u);



        }
        catch (Exception e){
            e.printStackTrace();
            Assertions.assertTrue(false);

        }
    }
    @Test
    public void subirProductoTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario,true,"imagen","Nintendo","Consola nintendo",3000.0,true, Estado_Producto.SIN_REVISAR, LocalDateTime.now().plusMonths(5),categorias,30);
        producto.setCodigo(1);
        try{
           usuarioServicio.registrarUsuario(usuario);
           Producto p = usuarioServicio.publicarProducto(producto);

            Assertions.assertNotNull(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void listarProductoPreciosTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");
        Set<Categoria_Producto> categorias = new HashSet<Categoria_Producto>();
        categorias.add(Categoria_Producto.BEBES);
        categorias.add(Categoria_Producto.CONSTRUCCION);
        categorias.add(Categoria_Producto.HERRAMIENTAS);
        Producto producto = new Producto(usuario,true,"imagen","Nintendo","Consola nintendo",3000.0,true, Estado_Producto.SIN_REVISAR, LocalDateTime.now().plusMonths(5),categorias,30);
        producto.setCodigo(1);


        Producto producto2 = new Producto(usuario,true,"imagen","Nintendo","Consola nintendo",5000.0,true, Estado_Producto.SIN_REVISAR, LocalDateTime.now().plusMonths(5),categorias,30);
        producto2.setCodigo(2);
        try{
            usuarioServicio.registrarUsuario(usuario);
          usuarioServicio.publicarProducto(producto);
            usuarioServicio.publicarProducto(producto2);
            List <Producto> lista = usuarioServicio.listarProductoPrecio(7000.0,3000.0);
            lista.forEach(System.out:: println );

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

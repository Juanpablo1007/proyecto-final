package co.edu.uniquindio.proyecto.test;
import java.util.*;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private  UsuarioRepo usuarioRepo;

    @Test
    public void registrarTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setCorreo("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setEstado(Estado_Cuenta.Activa);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }

    @Test
    public void eliminarTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setCorreo("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setEstado(Estado_Cuenta.Activa);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuario);
        Usuario buscado = usuarioRepo.findById("1001017577").orElse(null);
        Assertions.assertNull(buscado);

    }

    @Test
    public void actualizarTest (){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setCorreo("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setEstado(Estado_Cuenta.Activa);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioGuardado.setNombre("Didier");
        usuarioRepo.save(usuarioGuardado);
        Usuario buscado = usuarioRepo.findById("1001017577").orElse(null);
        Assertions.assertEquals("Didier", buscado.getNombre());


    }

    @Test
    public void listarTest(){
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setCorreo("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setEstado(Estado_Cuenta.Activa);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        List<Usuario> lista = usuarioRepo.findAll();

        System.out.println(lista);
    }
}

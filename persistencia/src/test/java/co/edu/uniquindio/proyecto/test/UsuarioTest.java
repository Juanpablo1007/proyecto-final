package co.edu.uniquindio.proyecto.test;


import java.util.*;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.crypto.spec.PSource;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

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

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }

    @Test
    public void eliminarTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuario);
        Usuario buscado = usuarioRepo.findById("1001017577").orElse(null);
        Assertions.assertNull(buscado);

    }

    @Test
    public void actualizarTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
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
    public void listarTest() {
        Usuario usuario = new Usuario();
        usuario.setCedula("1001017577");
        usuario.setEmail("juanp.delgadod@uqvirtual.edu.co");
        usuario.setContraseña("Juan123");
        usuario.setIsCuentaActiva(true);
        usuario.setTelefono("3218711230");
        usuario.setDireccion("Reserva de la pastorita");
        usuario.setNombre("Juan Pablo");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        List<Usuario> lista = usuarioRepo.findAll();

        System.out.println(lista);
    }

    @Test
    public void filtrarnNombreTest() {
        Usuario usuario3 = new Usuario("1001017579", "123", "didier", "yutud@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario2 = new Usuario("1001017578", "123", "juan david", "yutud1@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario1 = new Usuario("1001017577", "123", "juan pablo", "yutu6d1@hotmail.com", true, "3218711230", "reserva");
        usuarioRepo.save(usuario1);
        usuarioRepo.save(usuario2);
        usuarioRepo.save(usuario3);
        List<Usuario> lista = usuarioRepo.findAllByNombreContains("juan");
        lista.forEach(System.out::println);

    }

    @Test
    public void filtrarCorreoTest() {
        Usuario usuario1 = new Usuario("1001017579", "123", "didier", "yutud@hotmail.com", true, "3218711230", "reserva");
        usuarioRepo.save(usuario1);
        Optional<Usuario> usuario = usuarioRepo.findByEmail("yutud@hotmail.com");
        if (usuario.isPresent()) {
            System.out.println(usuario.get());
        } else {
            System.err.println("ese correo no exite");
        }

    }

    @Test
    public void verificarTest() {
        Usuario usuario1 = new Usuario("1001017579", "123", "didier", "yutud@hotmail.com", true, "3218711230", "reserva");
        usuarioRepo.save(usuario1);
        Optional<Usuario> usuario = usuarioRepo.findByEmailAndContraseña("yutud@hotmail.com", "123");
        if (usuario.isPresent()) {
            System.out.println(usuario.get());
        } else {
            System.err.println("el usuario o contraseña no coninciden");
        }

    }

    @Test
    public void paginarListaTest() {
        Usuario usuario4 = new Usuario("1001017580", "123", "daniel", "yutu@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario3 = new Usuario("1001017579", "123", "didier", "yutud@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario2 = new Usuario("1001017578", "123", "juan david", "yutud1@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario1 = new Usuario("1001017577", "123", "juan pablo", "yutu6d1@hotmail.com", true, "3218711230", "reserva");
        usuarioRepo.save(usuario1);
        usuarioRepo.save(usuario2);
        usuarioRepo.save(usuario3);
        usuarioRepo.save(usuario4);
        Pageable paginador = PageRequest.of(1, 2);
        Page<Usuario> lista = usuarioRepo.findAll(paginador);

        System.out.println(lista.stream().collect(Collectors.toList())); // hace la lista en partes, dependiendo de los pagueRequest
    }
    @Test
    public void ordenarListaTest() {
        Usuario usuario4 = new Usuario("1001017580", "123", "daniel", "yutu@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario3 = new Usuario("1001017579", "123", "didier", "yutud@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario2 = new Usuario("1001017578", "123", "juan david", "yutud1@hotmail.com", true, "3218711230", "reserva");
        Usuario usuario1 = new Usuario("1001017577", "123", "juan pablo", "yutu6d1@hotmail.com", true, "3218711230", "reserva");
        usuarioRepo.save(usuario1);
        usuarioRepo.save(usuario2);
        usuarioRepo.save(usuario3);
        usuarioRepo.save(usuario4);

        List<Usuario> lista = usuarioRepo.findAll(Sort.by("nombre")); //ordena por orden alfabetico

        System.out.println(lista);
    }

}

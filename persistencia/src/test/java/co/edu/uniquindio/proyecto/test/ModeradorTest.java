package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ModeradorTest {
    @Autowired
    private ModeradorRepo moderadorRepo;

    @Test

    public void registrarTest (){
        Moderador moderador = new Moderador("1001017577","123","Juan", "yutu6d1@hotmail.com" );
        Moderador moderadorGuardado = moderadorRepo.save(moderador);
        Assertions.assertNotNull(moderadorGuardado );
    }

    @Test
    public void eliminarTest(){
        Moderador moderador = new Moderador("1001017577","123","Juan", "yutu6d1@hotmail.com" );
        Moderador moderadorGuardado = moderadorRepo.save(moderador);
         moderadorRepo.delete(moderador);
        Moderador buscado = moderadorRepo.findById("1001017577").orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarTest (){
        Moderador moderador = new Moderador("1001017577","123","Juan", "yutu6d1@hotmail.com" );
        Moderador moderadorGuardado = moderadorRepo.save(moderador);
        moderadorGuardado.setNombre("pablo");
        Moderador buscado = moderadorRepo.findById("1001017577").orElse(null);
        Assertions.assertEquals("pablo", buscado.getNombre());
    }

    @Test
    public void listarTest(){
        Moderador moderador = new Moderador("1011007577","321","Pablo", "juanp.delgadod@uqvirtual.edu.co" );
        Moderador moderador1 = new Moderador("1001017577","123","Juan", "yutu6d1@hotmail.com" );
         moderadorRepo.save(moderador);
        moderadorRepo.save(moderador1);
        List<Moderador> lista = moderadorRepo.findAll();
        System.out.println(lista);
    }
}

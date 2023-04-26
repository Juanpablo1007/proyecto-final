package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ModeradorServicioTest {


    @Autowired
    private ModeradorServicio moderadorServicio;

    @Test
    public void registrarModeradoresTest() {
        Moderador moderador = new Moderador();
        moderador.setCedula("1000");
        moderador.setEmail("juanp.delgadod@uqvirtual.edu.co");
        moderador.setContraseña("Juan123");
        moderador.setNombre("juan Pablo");

        Moderador moderador1 = new Moderador();
        moderador1.setCedula("2000");
        moderador1.setEmail("juan.delgadod@uqvirtual.edu.co");
        moderador1.setContraseña("Juan12");
        moderador1.setNombre("juan Felipe");






        try {
            Moderador moderadorP = moderadorServicio.registrarModerador(moderador1);
            Moderador moderadorP1= moderadorServicio.registrarModerador(moderador);
            Assertions.assertNotNull(moderadorP1);
            Assertions.assertNotNull(moderadorP);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void prohibirProducto() {
        Moderador moderador = new Moderador();
        moderador.setCedula("1000");
        moderador.setEmail("juanp.delgadod@uqvirtual.edu.co");
        moderador.setContraseña("Juan123");
        moderador.setNombre("juan Pablo");

        Moderador moderador1 = new Moderador();
        moderador1.setCedula("2000");
        moderador1.setEmail("juan.delgadod@uqvirtual.edu.co");
        moderador1.setContraseña("Juan12");
        moderador1.setNombre("juan Felipe");






        try {
            Moderador moderadorP = moderadorServicio.registrarModerador(moderador1);
            Moderador moderadorP1= moderadorServicio.registrarModerador(moderador);
            Assertions.assertNotNull(moderadorP1);
            Assertions.assertNotNull(moderadorP);


        } catch (Exception e) {
            e.printStackTrace();
        }}





}

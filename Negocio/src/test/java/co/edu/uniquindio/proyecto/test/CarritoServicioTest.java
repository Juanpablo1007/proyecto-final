package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Carrito;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CarritoServicio;
import co.edu.uniquindio.proyecto.servicios.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CarritoServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CarritoServicio carritoServicio;

    @Test
    public void asignarCarritoAUsuario() throws Exception {
        Usuario usuario = new Usuario("1001017577","Juan123","Juan Pablo","juanp.delgadod@uqvirutal.edu.co",true,"3218711230","Reserva de la pastorita");
        try{
            Usuario usuarioCreado = usuarioServicio.registrarUsuario(usuario);
            Carrito carrito = new Carrito(usuarioCreado);
            Carrito carritoAsignado = carritoServicio.asignarCarrito(carrito,usuarioCreado.getCedula());
            System.out.println(carritoAsignado.getUsuario());
            System.out.println(usuarioCreado);
            Assertions.assertNotNull(carritoAsignado);
        }
        catch (Exception e) {
        e.printStackTrace();
            Assertions.assertNotNull(null);

        }

    }
}

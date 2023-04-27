package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImple implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final VentaRepo ventaRepo;

    public UsuarioServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.ventaRepo = ventaRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if (buscado.isPresent()) {
            throw new Exception("el codigo del usuario ya esta registrado");
        }
        buscado = usuarioRepo.findByEmailIgnoreCase(u.getEmail());

        if (buscado.isPresent()) {
            throw new Exception("el email del usuario ya existe");
        }

        return usuarioRepo.save(u);

    }

    @Override
    public Usuario ActualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if (buscado.isEmpty()) {

            throw new Exception("el codigo del usuario no esta registrado");
        }
        return usuarioRepo.save(u);


    }

    @Override
    public void EliminarUsuario(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if (buscado.isPresent()) {
            usuarioRepo.deleteById(cedula);

        } else {
            throw new Exception("el codigo del usuario no esta registrado");
        }


    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> logUsuario(String correo, String contraseña) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByEmailAndContraseña(correo, contraseña);
        if (buscado.isPresent()) {
            return buscado;
        }
        throw new Exception("El correo o contraseña esta incorrecto");
    }












    @Override
    public void RecuperarContraseña(String email, String contraseña) throws Exception {

    }



}


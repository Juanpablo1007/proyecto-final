package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;
import co.edu.uniquindio.proyecto.entidades.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
@Service
public  class ModeradorServicioImple implements  ModeradorServicio {


    private final ModeradorRepo moderadorRepo;
    private final ProductoRepo productoRepo;


 public ModeradorServicioImple(ModeradorRepo moderadorRepo, ProductoRepo productoRepo) {
 this.moderadorRepo= moderadorRepo;
 this.productoRepo = productoRepo;
 }

    @Override
    public Moderador registrarModerador (Moderador m){
     return  moderadorRepo.save(m);

    }



    @Override
    public Optional<Moderador> loginMod (String email, String contraseña) throws Exception {

    Optional <Moderador> buscado = moderadorRepo.findByEmailAndContraseña( email,  contraseña);
        if (buscado.isPresent()) {
            return buscado;
        }
        throw new Exception("El correo o contraseña esta incorrecto");


    }

    @Override

    public void prohibirProducto (Producto producto) throws Exception {
Optional<Producto> p = productoRepo.findById(producto.getCodigo());

        if (!p.isPresent()) {
            throw new Exception("Producto no esta registrado");




        }
        producto.setEstado(Estado_Producto.DENEGADO);
        productoRepo.save(producto);

    }


    @Override

    public void AutorizarProducto (Producto producto) throws Exception {

        Optional<Producto> p = productoRepo.findById(producto.getCodigo());

        if (!p.isPresent()) {
            throw new Exception("Producto no esta registrado");




        }
        producto.setEstado(Estado_Producto.AUTORIZADO);
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> listarProductosPorEstado() {
        return productoRepo.productosOrdenadosPorEstado();
    }


}


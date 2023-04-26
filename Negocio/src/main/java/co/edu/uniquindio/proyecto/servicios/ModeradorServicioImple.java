package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;
import co.edu.uniquindio.proyecto.entidades.*;

import java.util.Optional;
@Service
public class ModeradorServicioImple implements  ModeradorServicio {


    private final UsuarioRepo usuarioRepo;
    private final ModeradorRepo moderadorRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final VentaRepo ventaRepo;

 public ModeradorServicioImple(UsuarioRepo usuarioRepo,ModeradorRepo moderadorRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo) {
 this.usuarioRepo = usuarioRepo;
 this.moderadorRepo= moderadorRepo;
 this.productoRepo = productoRepo;
 this.carritoRepo = carritoRepo;
 this.comentarioRepo = comentarioRepo;
 this.compraRepo = compraRepo;
 this.ventaRepo = ventaRepo;
 }



    @Override

    public Moderador registrarModerador (Moderador moderador) throws Exception {
        Optional<Moderador> buscado = moderadorRepo.findById(moderador.getCedula());
        if (!buscado.isPresent()) {
            return moderadorRepo.save(moderador);
        }
        throw new Exception("Ya existe un producto con ese codigo");
    }


    @Override

    public Moderador prohibirProducto (Producto producto) throws Exception {
      /**

        if (!(producto ==null)) {

            productoGuardado.setEstado(Estado_Producto.DENEGADO);
            productoRepo.save(productoGuardado);
            Producto buscado = productoRepo.findById(producto.getCodigo()).orElse(null);
            Assertions.assertEquals(Estado_Producto.AUTORIZADO, buscado.getEstado());
            return moderadorRepo.save(moderador);
        }
        throw new Exception("Producto no disponibles para modificacion");**/
      return null;
    }


    @Override

    public Moderador AutorizarProducto (Producto producto) throws Exception {
        /**  Producto productoGuardado = productoRepo.findById(producto.getCodigo()).orElse(null);

        if (!(productoGuardado ==null)) {

            productoGuardado.setEstado(Estado_Producto.AUTORIZADO);
            productoRepo.save(productoGuardado);
            Producto buscado = productoRepo.findById(producto.getCodigo()).orElse(null);
            Assertions.assertEquals(Estado_Producto.AUTORIZADO, buscado.getEstado());
            return moderadorRepo.save(moderador);
        }
        throw new Exception("Producto no disponibles para modificacion");**/
        return null;
    }


}


package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServicioImple implements ProductoServicio{

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final VentaRepo ventaRepo;

    public ProductoServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.ventaRepo = ventaRepo;
    }

    @Override
    public Producto publicarProducto(Producto producto) throws Exception {

        return productoRepo.save(producto);
    }
}

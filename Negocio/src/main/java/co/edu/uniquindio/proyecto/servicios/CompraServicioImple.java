package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImple implements CompraServicio {

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final VentaRepo ventaRepo;

    public CompraServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.ventaRepo = ventaRepo;
    }

    @Override
    public Compra realizarCompra(Compra c,Usuario u, Producto p) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            return compraRepo.save(c);

        }
        if (p.getUnidades() < c.getUnidadesCompradas()) {
            throw new Exception("No hay suficientes unidades");
        }
        throw new Exception("el usuario o producto no estan registrados");

    }
}

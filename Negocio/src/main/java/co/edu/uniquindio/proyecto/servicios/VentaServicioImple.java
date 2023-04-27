package co.edu.uniquindio.proyecto.servicios;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServicioImple  implements VentaServicio{
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final VentaRepo ventaRepo;

    public VentaServicioImple(UsuarioRepo usuarioRepo,ProductoRepo productoRepo, VentaRepo ventaRepo ){
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.ventaRepo = ventaRepo;
    }
    @Override
    public Double calcularTotal(Integer codigo) {
        return ventaRepo.calcularTotalVentas(codigo);
    }

    @Override
    public Venta realizarVenta(Venta v, Usuario u, Producto p) throws Exception {


        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
           Venta venta = ventaRepo.save(v);
            Double total = calcularTotal(venta.getCodigo());
            venta.setTotal(total);
            Venta ventaGuardadaTotal = ventaRepo.save(venta);
            List<Venta> ventasUsuario = ventaRepo.findAllByUsuario_Cedula(usuario.get().getCedula());
            List<Venta> ventasProducto = ventaRepo.findAllByProducto_Codigo(producto.get().getCodigo());

            usuario.get().setVentas(ventasUsuario);
            usuarioRepo.save(usuario.get());


            producto.get().setVentas(ventasProducto);
            productoRepo.save(producto.get());

            return ventaGuardadaTotal;

        }
        if (p.getUnidades() < v.getUnidadesVendidas()) {
            throw new Exception("no hay suficientes unidades");
        }
        throw new Exception("el usuario o producto no estan registrados");

    }
}

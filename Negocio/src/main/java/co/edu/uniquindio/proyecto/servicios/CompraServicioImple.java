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
    private final CompraRepo compraRepo;


    public CompraServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CompraRepo compraRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.compraRepo = compraRepo;
    }

    @Override
    public Compra realizarCompra(Compra c,Usuario u, Producto p) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            if(usuario.get().getIsCuentaActiva()) {
                Compra compraGuardada = compraRepo.save(c);
                Double total = calcularTotalCompra(compraGuardada.getCodigo());
                compraGuardada.setTotal(total);
                compraGuardada = compraRepo.save(compraGuardada);
                List<Compra> comprasUsuario = compraRepo.findAllByUsuario_Cedula(usuario.get().getCedula());
                List<Compra> comprasProducto = compraRepo.findAllByProducto_Codigo(producto.get().getCodigo());

                usuario.get().setCompras(comprasUsuario);
                usuarioRepo.save(usuario.get());


                producto.get().setCompras(comprasProducto);
                productoRepo.save(producto.get());

                return compraGuardada;
            }else{
                throw new Exception("El usuario no esta activo");
            }

        }
        if (p.getUnidades() < c.getUnidadesCompradas()) {
            throw new Exception("No hay suficientes unidades");
        }
        throw new Exception("El usuario o producto no estan registrados");

    }

    @Override
    public Double calcularTotalCompra(Integer codigo) {
        return compraRepo.calcularTotalCompras(codigo);
    }

    @Override
    public List<Compra> listarComprasDeUsuario(Usuario u) {

        return compraRepo.findAllByUsuario_Cedula(u.getCedula());
    }
}

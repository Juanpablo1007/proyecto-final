package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.CompraPostDTO;
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
    public void realizarCompra(CompraPostDTO compraPostDTO) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(compraPostDTO.getUsuarioCedula());
        Optional<Producto> producto = productoRepo.findById(compraPostDTO.getProductoCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            if(usuario.get().getIsCuentaActiva()) {
                Compra compra = new Compra(LocalDateTime.now(),0.0,usuario.get(),compraPostDTO.getMetodoDePago(),producto.get(),compraPostDTO.getUnidadesCompradas());
                Compra compraGuardada = compraRepo.save(compra);
                Double total = calcularTotalCompra(compraGuardada.getCodigo());
                compraGuardada.setTotal(total);
                Compra compraGuardadaTotal = compraRepo.save(compraGuardada);
                List<Compra> comprasUsuario = compraRepo.findAllByUsuario_Cedula(usuario.get().getCedula());
                List<Compra> comprasProducto = compraRepo.findAllByProducto_Codigo(producto.get().getCodigo());

                usuario.get().setCompras(comprasUsuario);
                usuarioRepo.save(usuario.get());


                producto.get().setCompras(comprasProducto);
                producto.get().setUnidades(producto.get().getUnidades()-compraPostDTO.getUnidadesCompradas());
                productoRepo.save(producto.get());

            }else{
                throw new Exception("El usuario no esta activo");
            }

        }
        if (producto.get().getUnidades() < compraPostDTO.getUnidadesCompradas()) {
            throw new Exception("No hay suficientes unidades");
        }
        throw new Exception("El usuario o producto no estan registrados");

    }

    @Override
    public Double calcularTotalCompra(Integer codigo) {
        return compraRepo.calcularTotalCompras(codigo);
    }

  /**  @Override
    public List<Compra> listarComprasDeUsuario(Usuario u) {

        return compraRepo.findAllByUsuario_Cedula(u.getCedula());
    }**/
}

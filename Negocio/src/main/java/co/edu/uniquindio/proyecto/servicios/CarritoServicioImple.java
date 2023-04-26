package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoServicioImple implements CarritoServicio{

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final VentaRepo ventaRepo;
    private final CarritoProductosRepo carritoProductosRepo;

    public CarritoServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo, CarritoProductosRepo carritoProductosRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.ventaRepo = ventaRepo;
        this.carritoProductosRepo = carritoProductosRepo;
    }
    @Override
    public Carrito asignarCarrito(Carrito carrito, String cedula) throws Exception {
        Optional<Carrito> carritoUsuario = carritoRepo.findByUsuario_Cedula(cedula);

        if(carritoUsuario.isPresent()){
            throw new Exception("Ya existe un carrito asignado a ese user");
        }

        return carritoRepo.save(carrito);

    }

    @Override
    public void agregarProducto(Integer codigoProducto, Integer codigoCarrito, Integer unidades) throws Exception {

        Optional<Carrito> carrito = carritoRepo.findById(codigoCarrito);
        Optional<Producto> producto= productoRepo.findById(codigoProducto);

        if(carrito.isEmpty()){
            throw new Exception("No existe un carrito con ese codigo");
        }
        if(producto.isEmpty()){
            throw new Exception("No existe un producto con ese codigo");
        }
        if(unidades > producto.get().getUnidades()){
            throw new Exception("Sin stock");
        }

        CarritoProductos carritoProductos = new CarritoProductos(carrito.get(),producto.get(),unidades);
        carrito.get().getProductos().add(carritoProductos);
        producto.get().getCarritos().add(carritoProductos);
        CarritoProductos productoInfoBuscado = carritoProductosRepo.save(carritoProductos);


    }

    @Override
    public void eliminar(Integer codigoProducto, Carrito carrito) throws Exception {

    }

    @Override
    public void calcularTotalCarrito(Integer codigoCarrito) {

    }
}

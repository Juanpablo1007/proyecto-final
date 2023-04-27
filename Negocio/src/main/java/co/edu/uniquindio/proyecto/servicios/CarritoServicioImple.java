package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoServicioImple implements CarritoServicio{

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;

    private final CarritoProductosRepo carritoProductosRepo;

    public CarritoServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, CarritoProductosRepo carritoProductosRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.carritoProductosRepo = carritoProductosRepo;
    }
    @Override
    public Carrito asignarCarrito(Carrito carrito, Usuario usuario) throws Exception {

        usuario.setCarrito(carrito);
        carrito.setUsuario(usuario);
        usuarioRepo.save(usuario);

        return carritoRepo.save(carrito);

    }

    @Override
    public CarritoProductos agregarProducto(Integer codigoProducto, Integer codigoCarrito, Integer unidades) throws Exception {

        Optional<Carrito> carrito = carritoRepo.findById(codigoCarrito);
        Optional<Producto> producto= productoRepo.findById(codigoProducto);
        CarritoProductosLlave idCarritoProductos = new CarritoProductosLlave(codigoCarrito,codigoProducto);
        Optional<CarritoProductos> infoCarritoProductoEncontrado = carritoProductosRepo.findById(idCarritoProductos);

        if(carrito.isEmpty()){
            throw new Exception("No existe un carrito con ese codigo");
        }

        if(infoCarritoProductoEncontrado.isPresent()){
            throw new Exception("No se puede agregar un producto 2 veces");
        }

        if(producto.isEmpty()){
            throw new Exception("No existe un producto con ese codigo");
        }

        if(unidades > producto.get().getUnidades()){
            throw new Exception("Sin stock");
        }

        CarritoProductos carritoProductos = new CarritoProductos(carrito.get(),producto.get(),unidades);
        CarritoProductos productoInfoBuscado = carritoProductosRepo.save(carritoProductos);
        if(carrito.get().getProductos() == null) {
            List<CarritoProductos> productos = new ArrayList<CarritoProductos>();
            carrito.get().setProductos(productos);
        }
        if(producto.get().getCarritos() == null) {
            List<CarritoProductos> carritos = new ArrayList<CarritoProductos>();
            producto.get().setCarritos(carritos);
        }
        carrito.get().getProductos().add(productoInfoBuscado);
        producto.get().getCarritos().add(productoInfoBuscado);

        carritoRepo.save(carrito.get());
        productoRepo.save(producto.get());

        return productoInfoBuscado;

    }

    @Override
    public Boolean eliminarProducto(CarritoProductosLlave codigo) throws Exception {

        carritoRepo.deleteById(codigo.getCarritoCodigo());
        productoRepo.deleteById(codigo.getProductoCodigo());
        carritoProductosRepo.deleteById(codigo);

        if(carritoRepo.findById(codigo.getCarritoCodigo()).isEmpty() && productoRepo.findById(codigo.getProductoCodigo()).isEmpty() && carritoProductosRepo.findById(codigo).isEmpty())
        {
            return true;
        }
        return false;
    }

    @Override
    public Double calcularTotalCarrito(Integer codigoCarrito) {

        return carritoProductosRepo.calcularTotalCarrito(codigoCarrito);
    }
}

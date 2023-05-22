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
    public Carrito asignarCarrito(Carrito carrito, String usuarioCedula) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(usuarioCedula);

        if(usuario.isEmpty()){
            throw new Exception("No existe un usuario con esa id");
        }

        carrito.setUsuario(usuario.get());
        carritoRepo.save(carrito);

        Optional<Carrito> carritoBuscado = carritoRepo.findById(carrito.getCodigo());
        if(carritoBuscado.isEmpty()){
            throw new Exception("No existe un carrito con esa id");
        }
        usuario.get().setCarrito(carritoBuscado.get());
        usuarioRepo.save(usuario.get());

        return carritoBuscado.get();

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

        if(producto.isEmpty()){
            throw new Exception("No existe un producto con ese codigo");
        }

        if(unidades > producto.get().getUnidades()){
            throw new Exception("Sin stock");
        }
        CarritoProductos productoInfoBuscado = null;

        if(infoCarritoProductoEncontrado.isPresent()){
            Integer unidadesAnteriores= infoCarritoProductoEncontrado.get().getUnidades();
            infoCarritoProductoEncontrado.get().setUnidades(unidades+unidadesAnteriores);
            productoInfoBuscado = carritoProductosRepo.save(infoCarritoProductoEncontrado.get());
            carrito.get().getProductos().remove(productoInfoBuscado);
            producto.get().getCarritos().remove(productoInfoBuscado);
        }else{
            CarritoProductos carritoProductos = new CarritoProductos(carrito.get(),producto.get(),unidades);
             productoInfoBuscado = carritoProductosRepo.save(carritoProductos);
        }

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
    public CarritoProductos eliminarProducto(CarritoProductosLlave codigo) throws Exception {

        Optional<CarritoProductos> carritoProductos = carritoProductosRepo.findById(codigo);

        if(carritoProductos.isEmpty()){
            throw new Exception("El producto con esa id no se encuentra en el carrito con esa id");
        }

        Carrito carrito = carritoRepo.findById(codigo.getCarritoCodigo()).orElse(null);
        Producto producto = productoRepo.findById(codigo.getProductoCodigo()).orElse(null);

        carrito.getProductos().remove(carritoProductos.get());
        producto.getCarritos().remove(carritoProductos.get());
        carritoRepo.save(carrito);
        productoRepo.save(producto);
        carritoProductosRepo.deleteById(codigo);

        return carritoProductosRepo.findById(codigo).orElse(null);
    }

    @Override
    public Double calcularTotalCarrito(Integer codigoCarrito) {

        return carritoProductosRepo.calcularTotalCarrito(codigoCarrito);
    }
}

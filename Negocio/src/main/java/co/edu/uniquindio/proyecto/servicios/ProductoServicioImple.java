package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Estado_Producto;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Producto publicarProducto(Producto producto, Usuario usuario) throws Exception {

        if(usuario.getIsCuentaActiva()) {
            producto.setEstado(Estado_Producto.SIN_REVISAR);
            Producto productoGuardado = productoRepo.save(producto);
            List<Producto> productos = productoRepo.findAllByUsuario_Cedula(usuario.getCedula());
            usuario.setProductos(productos);
            Usuario usuarioActualizado = usuarioRepo.save(usuario);
            productoGuardado.setUsuario(usuarioActualizado);

            return productoRepo.save(productoGuardado);
        }else{
            throw new Exception("El usuario no tiene la cuenta activa");
        }
    }
    @Override

    public Producto comentarProducto  (Producto producto, Comentario co, Usuario u) throws Exception {
        Comentario comentario = comentarioRepo.save(co);
        Optional<Producto> p = productoRepo.findById(producto.getCodigo());
        Optional<Usuario> us = usuarioRepo.findById(u.getCedula());
        if(p.isPresent() && us.isPresent()){
            if(us.get().getIsCuentaActiva()){
            List<Comentario> c = productoRepo.buscarComentarios(producto.getCodigo());
            c.add(comentario);
            producto.setComentario(c);
            u.setComentarios(c);
            usuarioRepo.save(u);
            return productoRepo.save(producto);}
            else{
                throw new Exception("El usuario no esta activo");
            }
        }

        throw  new Exception("el producto o usuario no estan registrado");

    }

    @Override
    public void guardarProductoFavorito(Producto p, Usuario usuario) throws Exception {
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        Optional<Usuario> u = usuarioRepo.findById(usuario.getCedula());

        if(!producto.isPresent() ){
            throw  new Exception("el producto no se encuentra registrado");
        }
        if(!u.isPresent() ){
            throw  new Exception("el usuario no esta registrado");
        }
        if(!u.get().getIsCuentaActiva()){
            throw new Exception("El usuario no esta activo");
        }
        List<Producto> fav = usuarioRepo.buscarFavoritos(usuario.getCedula());
        System.out.println(fav.size());
        fav.add(p);
        usuario.setProductosFavoritos(fav);
        usuarioRepo.save(usuario);
    }

    @Override
    public void quitarProductoFavorito(Producto p,Usuario usuario) throws Exception {
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        Optional<Usuario> u = usuarioRepo.findById(usuario.getCedula());

        if(!producto.isPresent() ){
            throw  new Exception("el producto no se encuentra registrado");
        }
        if(!u.isPresent() ){
            throw  new Exception("el usuario no esta registrado");
        }
        List<Producto> fav = usuarioRepo.buscarFavoritos(usuario.getCedula());
        fav.remove(p);
        usuario.setProductosFavoritos(fav);
        usuarioRepo.save(usuario);
    }

    @Override
    public List<Producto> listarProductoPrecio(Double precioAlto, Double preciobajo) throws Exception {
        List<Producto> productos = productoRepo.listarPorRangoDePrecio(preciobajo, precioAlto);
        if (productos.isEmpty() ) {
            throw new Exception("no hay productos de estos precios");
        }
        return productos;
    }

    @Override
    public List<Producto> buscarProductoNombre(String nombre) throws Exception {
        List<Producto> productos = productoRepo.findAllByNombreContainsIgnoreCase(nombre);
        if (productos.isEmpty()) {
            throw new Exception("no hay productos con estos nombres");
        }
        return productos;
    }
    @Override
    public List<Producto> listarProductosPublicados(String cedula) throws Exception {
        List<Producto> productos = productoRepo.findAllByUsuario_Cedula(cedula);
        if (productos.isEmpty() || productos == null) {
            throw new Exception("No hay productos aun");
        }
        return productos;

    }

    @Override
    public List<Producto> listarProductosFavoritos(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if (buscado.isEmpty() ) {

            throw new Exception("el codigo del usuario no esta registrado");
        }

        if (u.getProductosFavoritos() == null || u.getProductosFavoritos().isEmpty() ) {
            throw new Exception("la lista de favoritos esta vacia");

        }

        return productoRepo.obtenerProductosDeUsuarioFavoritos(u.getCedula());
    }

    @Override
    public Producto ActualizarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if (buscado.isPresent()) {
            return productoRepo.save(producto);

        } else {
            throw new Exception("el codigo del producto no esta registrado");
        }


    }

    @Override
    public void EliminarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if (buscado.isPresent()) {
            productoRepo.deleteById(producto.getCodigo());

        } else {
            throw new Exception("el codigo del producto no esta registrado");
        }
    }

}

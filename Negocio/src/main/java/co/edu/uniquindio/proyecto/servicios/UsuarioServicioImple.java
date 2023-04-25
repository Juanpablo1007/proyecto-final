package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImple implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final CarritoRepo carritoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;

    public UsuarioServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
Optional<Usuario> buscado = usuarioRepo.findById( u.getCedula());
if(buscado.isPresent()){
   throw new  Exception( "el codigo del usuario ya esta registrado");
}
        buscado = usuarioRepo.findByEmailIgnoreCase( u.getEmail());

        if(buscado.isPresent()){
            throw new  Exception( "el email del usuario ya existe");
        }
    return usuarioRepo.save(u);

    }

    @Override
    public Usuario ActualizarUsuario(Usuario u) throws Exception {
       Optional<Usuario> buscado = usuarioRepo.findById( u.getCedula());
        if(buscado.isEmpty()){

            throw new  Exception( "el codigo del usuario no esta registrado");
        }
        return usuarioRepo.save(u);


    }

    @Override
    public void EliminarUsuario(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if(buscado.isPresent()){
            usuarioRepo.deleteById(cedula);

        }
        else{
            throw new  Exception( "el codigo del usuario no esta registrado");
        }


    }

    @Override
    public List<Usuario> listarUsuario()  {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional <Usuario> logUsuario(String correo, String contraseña) throws Exception {
        Optional <Usuario> buscado = usuarioRepo.findByEmailAndContraseña(correo,contraseña);
        if(buscado.isPresent()){
            return buscado;
        }
    throw new Exception("El correo o contraseña esta incorrecto");
    }

    @Override
    public Producto publicarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if(!buscado.isPresent()){
            return productoRepo.save(producto);
        }
       throw  new Exception("el id del producto ya existe");
    }



    @Override
    public Producto comentarProducto(Comentario comentario, Producto p) throws Exception {
        Optional<Comentario> buscado = comentarioRepo.findById(comentario.getCodigo());

        return null;
    }

    // este metodo le falta

    @Override
    public void guardarProductoFavorito(Producto producto) throws Exception {

    }

    @Override
    public void quitarProductoFavorito(Producto producto) throws Exception {

    }

    @Override
    public Compra comprarProducto(Carrito carrito) throws Exception {
        return null;
    }

    @Override
    public void RecuperarContraseña(String email, String contraseña) throws Exception {

    }



    @Override
    public List<Producto> listarProductoPrecio(Double precioAlto, Double preciobajo) throws Exception {
        List<Producto> productos = productoRepo.listarPorRangoDePrecio(preciobajo,precioAlto);
       if(productos.isEmpty()){
           throw new Exception("no hay productos de estos precios");
       }
        return productos;
    }

    @Override
    public List<Producto> buscarProductoNombre(String nombre)  {
        return productoRepo.findAllByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public List<Compra> listarCompras(Usuario u)  {
        return compraRepo.findAllByUsuario_Cedula(u.getCedula());
    }

    @Override
    public List<Producto> listarProductosPublicados() throws Exception {
        return null;
    }

    @Override
    public List<Producto> listarProductosFavoritos(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById( cedula);
        if(!buscado.isEmpty()){
            return productoRepo.obtenerProductosDeUsuarioFavoritos(cedula);

        }
        throw new  Exception( "el codigo del usuario no esta registrado");
    }

    @Override
    public Producto ActualizarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if(buscado.isPresent()){
            return productoRepo.save(producto);

        }

        throw new  Exception( "el codigo del producto no esta registrado");



    }

    @Override
    public void EliminarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if(buscado.isPresent()){
            productoRepo.deleteById(producto.getCodigo());

        }
        else{
            throw new  Exception( "el codigo del producto no esta registrado");
        }
    }
}

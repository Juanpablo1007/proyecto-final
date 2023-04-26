package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;


import org.springframework.beans.factory.annotation.Autowired;
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
    private final VentaRepo ventaRepo;

    public UsuarioServicioImple(UsuarioRepo usuarioRepo, ProductoRepo productoRepo, CarritoRepo carritoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, VentaRepo ventaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.carritoRepo = carritoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.ventaRepo = ventaRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if (buscado.isPresent()) {
            throw new Exception("el codigo del usuario ya esta registrado");
        }
        buscado = usuarioRepo.findByEmailIgnoreCase(u.getEmail());

        if (buscado.isPresent()) {
            throw new Exception("el email del usuario ya existe");
        }
        return usuarioRepo.save(u);

    }

    @Override
    public Usuario ActualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if (buscado.isEmpty()) {

            throw new Exception("el codigo del usuario no esta registrado");
        }
        return usuarioRepo.save(u);


    }

    @Override
    public void EliminarUsuario(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if (buscado.isPresent()) {
            usuarioRepo.deleteById(cedula);

        } else {
            throw new Exception("el codigo del usuario no esta registrado");
        }


    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> logUsuario(String correo, String contraseña) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByEmailAndContraseña(correo, contraseña);
        if (buscado.isPresent()) {
            return buscado;
        }
        throw new Exception("El correo o contraseña esta incorrecto");
    }

    @Override
    public Producto publicarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if (!buscado.isPresent()) {
            return productoRepo.save(producto);
        }
        throw new Exception("el id del producto ya existe");
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
        List<Producto> productos = productoRepo.listarPorRangoDePrecio(preciobajo, precioAlto);
        if (productos.isEmpty()) {
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

    @Override // este metodo no ha podido pasar el test
    public Compra registrarCompra(Usuario u, Producto p, Compra c) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            return compraRepo.save(c);

        }
        if (p.getUnidades() < c.getUnidadesCompradas()) {
            throw new Exception("no hay suficientes unidades");
        }
        throw new Exception("el usuario o producto no estan registrados");

    }

    @Override
    public Venta registrarVenta(Usuario u, Producto p, Venta v) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            return ventaRepo.save(v);

        }
        if (p.getUnidades() < v.getUnidadesVendidas()) {
            throw new Exception("no hay suficientes unidades");
        }
        throw new Exception("el usuario o producto no estan registrados");
    }

    public Compra registrarventa(Usuario u, Producto p, Compra c) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(u.getCedula());
        Optional<Producto> producto = productoRepo.findById(p.getCodigo());
        if (usuario.isPresent() && producto.isPresent()) {
            return compraRepo.save(c);

        }
        if (p.getUnidades() < c.getUnidadesCompradas()) {
            throw new Exception("no hay suficientes unidades");
        }
        throw new Exception("el usuario o producto no estan registrados");

    }



    @Override //este metodo se hace despues de arreglar el de registrar compra
    public List<Compra> listarCompras(Usuario u) {
        return compraRepo.findAllByUsuario_Cedula(u.getCedula());
    }

    @Override
    public List<Venta> listarVenta(Usuario u) throws Exception {
        return ventaRepo.findAllByUsuario_Cedula(u.getCedula());
    }

    @Override
    public List<Producto> listarProductosPublicados() throws Exception {
        List<Producto> productos = productoRepo.findAll();
        if (productos.isEmpty()) {
            throw new Exception("no hay productos aun");
        }
        return productos;

    }

    @Override
    public List<Producto> listarProductosFavoritos(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if (!buscado.isEmpty()) {
            return productoRepo.obtenerProductosDeUsuarioFavoritos(cedula);

        }
        throw new Exception("el codigo del usuario no esta registrado");
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
    public Compra ActualizarCompra(Compra compra) throws Exception {
        return compraRepo.save(compra);
    }

    @Override
    public Venta ActualizarVenta(Venta venta) throws Exception {
        return ventaRepo.save(venta);
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

    @Override
    public Long calcularTotal(String cedula) {
        return compraRepo.calcularTotalCompras(cedula);
    }

    @Override
    public Long calcularTotalVenta(String cedula) {
        return ventaRepo.calcularTotalVentas(cedula);
    }

}


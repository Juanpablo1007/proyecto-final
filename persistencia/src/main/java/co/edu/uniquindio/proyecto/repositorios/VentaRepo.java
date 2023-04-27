package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepo  extends JpaRepository<Venta, Integer> {

    List<Venta> findAllByFechaBefore(LocalDateTime fecha);

    List<Venta> findAllByUsuario_Nombre(String nombre);


    List<Venta> findAllByProducto_Codigo(Integer codigo);

    List<Venta> findAllByUsuario_Cedula(String cedula);
    @Query("select v.producto from Venta  v where v.usuario.cedula = :cedula ")
    List<Producto> obtenerListaProductosVendidos(String cedula);

    @Query ("select v.producto.precio * v.unidadesVendidas from Venta v where v.codigo = :codigo")
    Double calcularTotalVentas(Integer codigo);

}

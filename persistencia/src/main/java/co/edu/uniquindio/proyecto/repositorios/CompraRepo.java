package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository <Compra, Integer> {

    List<Compra> findAllByFechaBefore(LocalDateTime fecha);

    List<Compra> findAllByUsuario_Nombre(String nombre);

    List<Compra> findAllByProducto_Codigo(Integer codigo);

    List<Compra> findAllByUsuario_Cedula(String cedula);
@Query("select c.producto from Compra  c where c.usuario.cedula = :cedula ")
    List<Producto> obtenerListaProductosComprados(String cedula);

    @Query("select  count (distinct c.producto) from Compra  c where c.usuario.cedula = :cedula ")
    Long obtenerListaProductosCompradosSinRepetir(String cedula);

    @Query ("select sum(c.producto.precio * c.unidadesCompradas) from Compra c where c.usuario.cedula = :cedula")
    Long calcularTotalCompras(String cedula);



}

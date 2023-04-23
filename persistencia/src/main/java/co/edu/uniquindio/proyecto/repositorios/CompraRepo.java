package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository <Compra, Integer> {

    List<Compra> findAllByFechaBefore(LocalDateTime fecha);

    List<Compra> findAllByUsuario_Nombre(String nombre);

    List<Compra> findAllByProducto_Codigo(Integer codigo);

}

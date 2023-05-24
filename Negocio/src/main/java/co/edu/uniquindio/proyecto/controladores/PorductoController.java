package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeGetDTO;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping( value = "api/Producto")
public class PorductoController {/**
    @Autowired
    private final ProductoServicio servicio;
    @PostMapping
    public ResponseEntity<MensajeGetDTO> publicarProducto(@Valid @RequestBody Producto p, @Valid @RequestBody Usuario usuario) throws Exception {
        servicio.publicarProducto(p,usuario);
        return ResponseEntity.status(201).body(new MensajeGetDTO(HttpStatus.CREATED, false,
                "producto publicado correctamente"));
    }
    @PutMapping()
    public ResponseEntity<MensajeGetDTO> comentarProducto (@Valid @RequestBody Producto p, @Valid @RequestBody Comentario co, @Valid @RequestBody Usuario u) throws Exception {

        servicio.comentarProducto(p,co,u);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "producto comentado con exito" ) );
    } @PutMapping()
    public ResponseEntity<MensajeGetDTO> guardarProductoFavorito (@Valid @RequestBody Producto p, @Valid @RequestBody Usuario u) throws Exception {

        servicio.guardarProductoFavorito(p, u);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "producto favorito guardado" ) );
    }

    @GetMapping
    public List<Producto> listarProductoPrecio(@RequestParam Double precioBajo, @RequestParam Double precioAlto) throws Exception {
        return servicio.listarProductoPrecio(precioBajo,precioAlto);
    }
    @GetMapping("/{nombre}")
    public List<Producto> listarProductoPrecio(@PathVariable String nombre) throws Exception {
        return servicio.buscarProductoNombre(nombre);
    }@GetMapping("/{cedula}")
    public List<Producto> listarProductosPublicados(@PathVariable String cedula) throws Exception {
        return servicio.listarProductosPublicados(cedula);
    }
    @GetMapping
    public List<Producto> listarProductosFavoritos(@Valid @RequestBody Usuario u) throws Exception {
        return servicio.listarProductosFavoritos(u);
    }
    @PutMapping()
    public ResponseEntity<MensajeGetDTO> Actualizar(@Valid @RequestBody Producto producto) throws Exception {

        servicio.ActualizarProducto(producto);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Actualizado correctamente" ) );
    }
    @DeleteMapping
    public ResponseEntity<MensajeGetDTO> eliminar(@PathVariable Producto producto) throws Exception {
        servicio.EliminarProducto(producto);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Eliminado correctamente" ) );
    }**/
}

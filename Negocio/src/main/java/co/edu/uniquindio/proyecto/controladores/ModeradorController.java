package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping( "api/moderador")
public class ModeradorController {
    private final ModeradorServicio servicio;
    @PostMapping
    public ResponseEntity<MensajeDTO> registrar(@Valid @RequestBody Moderador moderador) throws Exception {
        servicio.registrarModerador(moderador);
        return ResponseEntity.status(201).body(new MensajeDTO(HttpStatus.CREATED, false,
                "moderador creado correctamente"));
    }
    @GetMapping("/{correo}" )
    public ResponseEntity<MensajeDTO> log(@PathVariable String correo,@PathVariable String contraseña) throws Exception {
        servicio.loginMod(correo, contraseña);
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false,
                servicio.loginMod(correo, contraseña) ) );
    }
    @PutMapping()
    public ResponseEntity<MensajeDTO> autorizarProducto(@Valid @RequestBody Producto u) throws Exception {

        servicio.AutorizarProducto(u);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "producto autorizado" ) );
    }
    @PutMapping()
    public ResponseEntity<MensajeDTO> prohibirProducto(@Valid @RequestBody Producto u) throws Exception {

        servicio.prohibirProducto(u);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "producto prohibido" ) );
    }
    @GetMapping
    public List<Producto> listar() throws Exception {
        return servicio.listarProductosPorEstado();
    }
}

package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;

import co.edu.uniquindio.proyecto.entidades.*;
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
@RequestMapping( "api/usuario")
public class UsuarioController {
    @Autowired
    private final UsuarioServicio servicio;
  @GetMapping
   public List<Usuario> listar() throws Exception {
        return servicio.listarUsuario();
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> registrar(@Valid @RequestBody Usuario usuario) throws Exception {
        servicio.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(new MensajeDTO(HttpStatus.CREATED, false,
                "Usuario creado correctamente"));
    }
    @DeleteMapping("/{cedula}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable String cedula) throws Exception {
      servicio.EliminarUsuario(cedula);
      return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
              "Eliminado correctamente" ) );
    }
    @GetMapping("/{correo}" )
    public ResponseEntity<MensajeDTO> log(@PathVariable String correo,@PathVariable String contraseña) throws Exception {
      servicio.logUsuario(correo, contraseña);
      return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false,
              servicio.logUsuario(correo, contraseña) ) );
    }
    @PutMapping()
    public ResponseEntity<MensajeDTO> Actualizar(@Valid @RequestBody Usuario usuario) throws Exception {

      servicio.ActualizarUsuario(usuario);
      return  ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "Actualizado correctamente" ) );
    }
}

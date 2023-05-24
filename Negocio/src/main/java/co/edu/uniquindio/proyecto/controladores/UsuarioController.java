package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeGetDTO;

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
@RequestMapping(value = "api/usuario")
public class UsuarioController {/**
    @Autowired
    private final UsuarioServicio servicio;
  @GetMapping
   public List<Usuario> listar() throws Exception {
        return servicio.listarUsuario();
    }

    @PostMapping
    public ResponseEntity<MensajeGetDTO> registrar(@Valid @RequestBody Usuario usuario) throws Exception {
        servicio.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(new MensajeGetDTO(HttpStatus.CREATED, false,
                "Usuario creado correctamente"));
    }
    @DeleteMapping("/{cedula}")
    public ResponseEntity<MensajeGetDTO> eliminar(@PathVariable String cedula) throws Exception {
      servicio.EliminarUsuario(cedula);
      return ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
              "Eliminado correctamente" ) );
    }
    @GetMapping("/{correo}" )
    public ResponseEntity<MensajeGetDTO> log(@PathVariable String correo, @PathVariable String contraseña) throws Exception {
      servicio.logUsuario(correo, contraseña);
      return ResponseEntity.status(200).body( new MensajeGetDTO(HttpStatus.OK, false,
              servicio.logUsuario(correo, contraseña) ) );
    }
    @PutMapping()
    public ResponseEntity<MensajeGetDTO> Actualizar(@Valid @RequestBody Usuario usuario) throws Exception {

      servicio.ActualizarUsuario(usuario);
      return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Actualizado correctamente" ) );
    }**/
}

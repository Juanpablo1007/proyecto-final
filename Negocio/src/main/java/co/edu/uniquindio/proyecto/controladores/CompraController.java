package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeGetDTO;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping( value = "api/Compra")
public class CompraController {/**
@Autowired
   private final CompraServicio servicio;
    @PostMapping
    public ResponseEntity<MensajeGetDTO> realizarCompra(@Valid @RequestBody Compra compra, @Valid @RequestBody Usuario u, @Valid @RequestBody  Producto p) throws Exception {

        servicio.realizarCompra(compra, u, p);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.CREATED, false,
                "se realizo la compra de manera satisfactoria" ) );
    }
    @PutMapping("/{codigoCarrito}")
    public ResponseEntity<MensajeGetDTO> calcularTotalCompra(@PathVariable Integer codigoCarrito) throws Exception {

        servicio.calcularTotalCompra(codigoCarrito);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Se calculo el total de la compra con exito " ) );
    }
    @GetMapping
    public List<Compra> listarCompras(@Valid @RequestBody Usuario u) throws Exception {
        return servicio.listarComprasDeUsuario(u);
    }**/
}

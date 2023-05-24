package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeGetDTO;

import co.edu.uniquindio.proyecto.entidades.*;

import co.edu.uniquindio.proyecto.servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/Compra")
public class VentaController {/**
    @Autowired
private final VentaServicio servicio;
    @PostMapping
    public ResponseEntity<MensajeGetDTO> realizarVenta(@Valid @RequestBody Venta venta, @Valid @RequestBody Usuario u, @Valid @RequestBody Producto p) throws Exception {
        servicio.realizarVenta(venta, u, p);
        return ResponseEntity.status(201).body(new MensajeGetDTO(HttpStatus.CREATED, false,
                "venta realizada con exito"));
    }
    @PutMapping("/{codigo}" )
    public ResponseEntity<MensajeGetDTO> Actualizar(@PathVariable Integer codigo ) throws Exception {

        servicio.calcularTotal(codigo);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "total calculado coreectamente" ) );
    }**/
}

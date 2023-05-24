package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeGetDTO;

import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.CarritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping( value = "api/carrito")
public class CarritoController {/**
    @Autowired
    private final CarritoServicio servicio;
    @PutMapping()
    public ResponseEntity<MensajeGetDTO> asignarCarrito(@Valid @RequestBody Carrito carrito, @Valid @RequestBody UsuarioGetDTO usuarioGetDTO) throws Exception {

        servicio.asignarCarrito(carrito, usuarioGetDTO);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "se asigno el carrito de manera adecuada" ) );
    }
    @DeleteMapping()
    public ResponseEntity<MensajeGetDTO> EliminarProducto(@Valid @RequestBody CarritoProductosLlave codigo) throws Exception {

        servicio.eliminarProducto(codigo);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Se elimino el producto de manera satisfactoria" ) );
    }
    @PutMapping("/{codigoProduto}")
    public ResponseEntity<MensajeGetDTO> AgregarProducto(@PathVariable Integer codigoProduto, @RequestBody Integer codigoCarrito, @RequestBody Integer unidades) throws Exception {

        servicio.agregarProducto(codigoProduto, codigoCarrito, unidades);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Se agrego el producto de manera satisfactoria" ) );
    }
    @PutMapping("/{codigoCarrito}")
    public ResponseEntity<MensajeGetDTO> calcularTotalCarrito(@PathVariable Integer codigoCarrito) throws Exception {

        servicio.calcularTotalCarrito(codigoCarrito);
        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeGetDTO(HttpStatus.OK, false,
                "Se " ) );
    }
**/
}

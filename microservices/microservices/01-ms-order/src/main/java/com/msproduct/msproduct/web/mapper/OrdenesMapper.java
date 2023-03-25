package com.msproduct.msproduct.web.mapper;

import com.msproduct.msproduct.exception.BadRequestException;
import com.msproduct.msproduct.model.Ordenes;
import com.msproduct.msproduct.model.Payment;
import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.service.OrdenesService;
import com.msproduct.msproduct.service.PaymentService;
import com.msproduct.msproduct.web.message.OrdenesMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;

@Component
public class OrdenesMapper {

    private final OrdenesService ordenesService;

    private final PaymentService paymentService;

    public OrdenesMapper(OrdenesService ordenesService, PaymentService paymentService){
        this.ordenesService =ordenesService;
        this.paymentService =paymentService;
    }

    public Ordenes crearPrueba(OrdenesMessage message){


        Producto producto = ordenesService.validarPRoduct(message.getProducto_id())
                .orElseThrow(() -> new BadRequestException(""));

        Payment payment = paymentService.validarPayment(message.getPayment_id())
                .orElseThrow(() -> new BadRequestException("Payment no encontrado"));


            Ordenes ordenes = new Ordenes();
            double subtotal = producto.getPrecioVenta() * message.getCantidad();

     return new Ordenes(producto.getId(),message.getCantidad(), payment,subtotal,true);
     }


     /**
      * public Ordenes crearPrueba(OrdenesMessage message){
      *         ResponseEntity<Producto> producto = ordenesService.validarPRoduct(message.getProducto_id())
      *                 .map(data -> ResponseEntity.ok().body(data))
      *                 .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).block();
      *
      *         Ordenes ordenes = new Ordenes();
      *
      *         Long cantidad = message.getCantidad();
      *         double precio = producto.getBody().getPrecioVenta().doubleValue();
      *
      *         ordenes.setProducto(producto.getBody());
      *         ordenes.setCantidad(cantidad);
      *         ordenes.setPrecio(precio * cantidad);
      *         ordenes.setEstado(true);
      *      return ordenes;
      *      }**/

}

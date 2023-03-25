package com.msproduct.msproduct.web.message;

import java.math.BigDecimal;

public class OrdenesMessage {


    private final Long producto_id;
    private final Long cantidad;

    private final Long payment_id;


    public OrdenesMessage(Long producto_id, Long cantidad, Long payment_id) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.payment_id = payment_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Long getPayment_id() {
        return payment_id;
    }
}

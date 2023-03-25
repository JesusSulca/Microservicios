package com.msproduct.msproduct.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order_id")
    @SequenceGenerator(name = "seq_order_id", sequenceName = "seq_order_id",allocationSize = 1)
    private Long id;


    private Long producto_id;

    private Long cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    private Payment payment;

    private double precio;

    private boolean estado;


    public Ordenes(){

    }


    public Ordenes(Long producto_id, Long cantidad, Payment payment, double precio, boolean estado) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.payment = payment;
        this.precio = precio;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

package com.msproduct.msproduct.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_id")
    @SequenceGenerator(sequenceName = "seq_payment_id",name = "seq_payment_id", allocationSize = 1)
    private Long id;

    private String nombre;

    private boolean estado;

    public Payment(){

    }

    public Payment(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

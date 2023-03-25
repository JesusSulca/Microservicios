package com.msproduct.msproduct.service;

import com.msproduct.msproduct.model.Payment;


import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Payment Create(Payment payment);

    Payment update(Payment payment);

    List<Payment> finall();

    Payment finbyId(Long id);

    Optional<Payment> validarPayment(Long id);
}

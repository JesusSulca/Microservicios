package com.msproduct.msproduct.service.impl;

import com.msproduct.msproduct.exception.NotFoundException;
import com.msproduct.msproduct.model.Payment;
import com.msproduct.msproduct.repository.PaymentRepository;
import com.msproduct.msproduct.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment Create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public List<Payment> finall() {
        return (List<Payment>) paymentRepository.findAll();
    }

    @Override
    public Payment finbyId(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Numero de ID no encontrado:  " + id));
    }

    @Override
    public Optional<Payment> validarPayment(Long id) {
        return paymentRepository.findById(id);
    }
}

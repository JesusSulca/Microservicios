package com.msproduct.msproduct.web;

import com.msproduct.msproduct.model.Payment;
import com.msproduct.msproduct.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-payment/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    };

    @GetMapping
    public List<Payment> findAll(){
        return paymentService.finall();
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment){
        return paymentService.Create(payment);
    }

    @GetMapping("/buscar/{id}")
    public Payment finById(@PathVariable Long id){
        return paymentService.finbyId(id);
    }
}

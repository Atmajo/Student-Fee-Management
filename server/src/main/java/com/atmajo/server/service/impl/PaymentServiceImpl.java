package com.atmajo.server.service.impl;

import com.atmajo.server.model.Payment;
import com.atmajo.server.repository.PaymentRepo;
import com.atmajo.server.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo){ this.paymentRepo = paymentRepo; }

    @Override
    public void createPayment(Payment payment) {
        paymentRepo.save(payment);
    }
}

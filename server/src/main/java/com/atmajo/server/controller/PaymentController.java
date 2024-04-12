package com.atmajo.server.controller;

import com.atmajo.server.model.Payment;
import com.atmajo.server.model.User;
import com.atmajo.server.repository.UserRepo;
import com.atmajo.server.service.PaymentService;
import com.atmajo.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentController {

    PaymentService paymentService;
    UserService userService;
    UserRepo userRepo;

    public PaymentController(PaymentService paymentService, UserService userService, UserRepo userRepo ){
        this.paymentService = paymentService;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/payment/savePayment")
    public ResponseEntity<String> createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        Long enrollment = payment.getEnrollment();
        System.out.println(enrollment);

        User user = userRepo.findById(enrollment).get();

        int currentSemester = user.getSemester();
        user.setSemester(currentSemester);

        Long pendingPayment = user.getPending();
        Long amount = payment.getAmount();

        user.setPending(pendingPayment-amount);
        userService.updateUser(enrollment, user);

        return new ResponseEntity<String>("Payment successful", HttpStatus.OK);
    }
}

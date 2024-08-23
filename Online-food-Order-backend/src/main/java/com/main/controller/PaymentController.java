package com.main.controller;

import com.main.entity.Payment;
import com.main.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/{userId}")
    public ResponseEntity<Payment> createPayment(
            @RequestBody Payment payment,
            @PathVariable("userId") int userId) { // userId is a path variable
        try {
            Payment savedPayment = paymentService.savePayment(payment, userId);
            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
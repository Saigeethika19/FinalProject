package com.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Payment;
import com.main.entity.UserRegistration;
import com.main.repostiary.PaymentRepository;
import com.main.repostiary.UserRepo;
import com.main.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired 
    private UserRepo userRepo;

	@Override
	 public Payment savePayment(Payment payment, int userId) {
        // Find the user by ID
         UserRegistration user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the user on the payment
        payment.setUser(user);

        // Save the payment
        return paymentRepository.save(payment);
    }
}

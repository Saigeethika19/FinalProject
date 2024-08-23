package com.main.repostiary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}

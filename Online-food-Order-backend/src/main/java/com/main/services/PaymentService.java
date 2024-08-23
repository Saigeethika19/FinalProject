package com.main.services;

import com.main.entity.Payment;

public interface PaymentService {
	 Payment savePayment(Payment payment, int userId);
}

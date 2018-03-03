package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.f3.pay.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Payment findById(String id);
	Payment findByPaymentId (Long id);
	
	

}

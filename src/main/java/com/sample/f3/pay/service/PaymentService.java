package com.sample.f3.pay.service;


import com.sample.f3.pay.model.Payment;

public interface PaymentService {
	boolean checkPaymentData (Payment payment);
	boolean copyKeysForUpdate (Payment src, Payment dest);
}

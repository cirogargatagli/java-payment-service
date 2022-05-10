package com.ajsw.java.payment.service.repositories;

import com.ajsw.java.payment.service.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}

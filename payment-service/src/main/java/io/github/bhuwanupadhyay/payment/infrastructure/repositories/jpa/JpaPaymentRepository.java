package io.github.bhuwanupadhyay.payment.infrastructure.repositories.jpa;

import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPaymentRepository extends JpaRepository<Payment, Long> {
  Optional<Payment> findFirstByPaymentId(PaymentId paymentId);
}

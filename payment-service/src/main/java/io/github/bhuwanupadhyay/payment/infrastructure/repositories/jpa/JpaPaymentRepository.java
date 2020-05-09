package io.github.bhuwanupadhyay.payment.infrastructure.repositories.jpa;

import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepository extends JpaRepository<Payment, Long> {
  Optional<Payment> findFirstByPaymentId(PaymentId paymentId);
}

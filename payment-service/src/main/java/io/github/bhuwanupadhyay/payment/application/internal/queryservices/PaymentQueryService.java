package io.github.bhuwanupadhyay.payment.application.internal.queryservices;

import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.infrastructure.repositories.jpa.JpaPaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentQueryService {

  private final JpaPaymentRepository repository;

  public List<Payment> getPayments() {
    return repository.findAll();
  }
}

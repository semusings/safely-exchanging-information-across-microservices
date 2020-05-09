package io.github.bhuwanupadhyay.payment.infrastructure.repositories;

import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import io.github.bhuwanupadhyay.payment.infrastructure.repositories.jpa.JpaPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PaymentRepository {

	private final JpaPaymentRepository repository;
	/**
	 * Stores the Payment Aggregate
	 *
	 * @param payment
	 */
	public void store(Payment payment) {
		repository.save(payment);
	}

	/**
	 * Gets next Order Identifier
	 *
	 * @return
	 */
	public PaymentId nextPaymentId() {
		String random = UUID.randomUUID().toString().toUpperCase();
		return new PaymentId(random.substring(0, random.indexOf("-")));
	}

	public Optional<Payment> findByOrderId(PaymentId paymentId) {
		return repository.findFirstByPaymentId(paymentId);
	}
}

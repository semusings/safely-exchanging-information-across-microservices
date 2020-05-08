package io.github.bhuwanupadhyay.payment.domain.model.aggregates;

import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.OrderAmount;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends AbstractAggregateRoot<Payment> {

	@Id //Identifier Annotation provided by JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Rely on a RDBMS generated sequence
	private Long id;
	@Embedded
	private PaymentId paymentId; //Globally unique identifier of the Payment Root Aggregate (Payment Id)
	@Embedded
	private OrderAmount orderAmount;

	public Payment(PaymentId paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Payment payment = (Payment) o;
		return Objects.equals(id, payment.id) &&
				Objects.equals(paymentId, payment.paymentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, paymentId);
	}
}

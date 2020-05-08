package io.github.bhuwanupadhyay.order.domain.model.aggregates;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends AbstractAggregateRoot<Order> {
	@Id // Identifier Annotation provided by JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Rely on a RDBMS generated sequence
	private Long id;

	@Embedded
	private OrderId orderId; // Globally unique identifier of the Order Root Aggregate (Order Id)

	public Order(OrderId orderId) {
		this.orderId = orderId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order payment = (Order) o;
		return Objects.equals(id, payment.id) && Objects.equals(orderId, payment.orderId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderId);
	}
}

package io.github.bhuwanupadhyay.order.application.internal.commandservices;

import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderCommandService {

	private final OrderRepository orderRepository;

	@Transactional
	public OrderId createOrder(CreateOrderCommand createOrderCommand) {
		final OrderId orderId = orderRepository.nextOrderId();
		final Order order = new Order(orderId);
		this.orderRepository.store(order);
		return orderId;
	}

}

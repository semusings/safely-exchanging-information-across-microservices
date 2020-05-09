package io.github.bhuwanupadhyay.order.application.internal.commandservices;

import io.github.bhuwanupadhyay.order.application.internal.outboundservices.acl.ExternalInventoryService;
import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.*;
import io.github.bhuwanupadhyay.order.infrastructure.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderCommandService {

  private final OrderRepository orderRepository;
  private final ExternalInventoryService externalInventoryService;

  @Transactional
  public OrderId createOrder(CreateOrderCommand createOrderCommand) {
    final OrderId orderId = orderRepository.nextOrderId();
    final ItemId itemId = new ItemId(createOrderCommand.getItemId());
    final CustomerId customerId = new CustomerId(createOrderCommand.getCustomerId());
    final Quantity quantity = new Quantity(createOrderCommand.getQuantity());

    final Order order = new Order(orderId, itemId, customerId, quantity);

    final ItemPrice itemPrice = this.externalInventoryService.fetchItemPrice(order.getItemId());

    order.evaluatePrice(itemPrice);
    this.orderRepository.store(order);

    return order.getOrderId();
  }
}

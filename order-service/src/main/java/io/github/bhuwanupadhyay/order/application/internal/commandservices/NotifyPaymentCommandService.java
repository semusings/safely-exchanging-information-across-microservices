package io.github.bhuwanupadhyay.order.application.internal.commandservices;

import io.github.bhuwanupadhyay.order.domain.commands.NotifyPaymentCommand;
import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.PaymentId;
import io.github.bhuwanupadhyay.order.infrastructure.repositories.OrderRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotifyPaymentCommandService {

  private final OrderRepository orderRepository;

  @Transactional
  public void notifyPayment(NotifyPaymentCommand notifyPaymentCommand) {
    final Optional<Order> oneOrder =
        orderRepository.findByOrderId(new OrderId(notifyPaymentCommand.getOrderId()));
    if (oneOrder.isPresent()) {
      final Order order = oneOrder.get();
      order.notifyOrder(new PaymentId(notifyPaymentCommand.getPaymentId()));
      orderRepository.store(order);
    } else {
      LOG.error("No order found for {}", notifyPaymentCommand.getOrderId());
    }
  }
}

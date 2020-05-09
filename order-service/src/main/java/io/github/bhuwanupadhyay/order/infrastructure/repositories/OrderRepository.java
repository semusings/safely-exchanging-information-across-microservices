package io.github.bhuwanupadhyay.order.infrastructure.repositories;

import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import java.util.Optional;
import java.util.UUID;

import io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

  private final JpaOrderRepository repository;

  /**
   * Stores the Order Aggregate
   *
   * @param order
   */
  public void store(Order order) {
    repository.save(order);
  }

  /**
   * Gets next Order Identifier
   *
   * @return
   */
  public OrderId nextOrderId() {
    String random = UUID.randomUUID().toString().toUpperCase();
    return new OrderId(random.substring(0, random.indexOf("-")));
  }

  public Optional<Order> findByOrderId(OrderId orderId) {
    return repository.findFirstByOrderId(orderId);
  }
}

package io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa;

import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

  private final SpringDataOrderRepository repository;

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

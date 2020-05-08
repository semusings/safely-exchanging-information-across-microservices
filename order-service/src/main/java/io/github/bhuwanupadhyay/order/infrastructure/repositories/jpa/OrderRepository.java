package io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa;

import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

  interface SpringDataOrderRepository extends JpaRepository<Order, Long> {}
}

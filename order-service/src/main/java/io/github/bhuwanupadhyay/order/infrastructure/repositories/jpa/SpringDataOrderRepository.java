package io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa;

import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SpringDataOrderRepository extends JpaRepository<Order, Long> {

  @Transactional(readOnly = true)
  Optional<Order> findFirstByOrderId(OrderId orderId);
}

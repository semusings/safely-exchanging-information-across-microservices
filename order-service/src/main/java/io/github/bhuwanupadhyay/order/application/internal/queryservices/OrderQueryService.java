package io.github.bhuwanupadhyay.order.application.internal.queryservices;

import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.infrastructure.repositories.jpa.SpringDataOrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

  private final SpringDataOrderRepository repository;

  public List<Order> getOrders() {
    return repository.findAll();
  }
}

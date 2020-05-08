package io.github.bhuwanupadhyay.order.domain.model.aggregates;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.*;
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

  // Globally unique identifier of the Order Root Aggregate (Order Id)
  @Embedded private OrderId orderId;

  @Embedded private OrderAmount orderAmount;

  @Embedded private ItemId itemId;
  @Embedded private Quantity quantity;

  public Order(OrderId orderId, ItemId itemId, Quantity quantity) {
    this.orderId = orderId;
    this.itemId = itemId;
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id) && Objects.equals(orderId, order.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId);
  }

  public void evaluatePrice(ItemPrice itemPrice) {

  }
}

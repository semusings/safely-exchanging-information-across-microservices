package io.github.bhuwanupadhyay.order.domain.model.aggregates;

import io.github.bhuwanupadhyay.order.domain.events.PaymentRequestedEvent;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.*;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "OMS_ORDER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends AbstractAggregateRoot<Order> {
  @Id // Identifier Annotation provided by JPA
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Rely on a RDBMS generated sequence
  private Long id;

  // Globally unique identifier of the Order Root Aggregate (Order Id)
  @Embedded private OrderId orderId;

  @Embedded private OrderAmount orderAmount;
  @Embedded private CustomerId customerId;
  @Embedded private ItemId itemId;
  @Embedded private PaymentId paymentId;
  @Embedded private Quantity quantity;

  public Order(OrderId orderId, ItemId itemId, CustomerId customerId, Quantity quantity) {
    this.customerId = customerId;
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
    final BigDecimal quantity = BigDecimal.valueOf(this.quantity.getQuantity());
    final BigDecimal amount = itemPrice.getItemPrice().multiply(quantity);
    this.orderAmount = new OrderAmount(amount, "USD");
    this.registerEvent(new PaymentRequestedEvent(orderId, customerId, orderAmount));
  }

  public void notifyOrder(PaymentId paymentId) {
    this.paymentId = paymentId;
  }
}

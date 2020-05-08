package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderId {

  @Column(name = "ORDER_ID")
  private String orderId;

  public OrderId(String orderId) {
    this.orderId = orderId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderId paymentId = (OrderId) o;
    return Objects.equals(paymentId, paymentId.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }
}

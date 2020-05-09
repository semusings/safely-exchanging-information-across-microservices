package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentId {

  @Column(name = "PAYMENT_ID")
  private String paymentId;

  public PaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PaymentId paymentId1 = (PaymentId) o;
    return Objects.equals(paymentId, paymentId1.paymentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId);
  }
}

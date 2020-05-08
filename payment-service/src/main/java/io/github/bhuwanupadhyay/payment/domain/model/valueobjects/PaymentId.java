package io.github.bhuwanupadhyay.payment.domain.model.valueobjects;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    PaymentId paymentId = (PaymentId) o;
    return Objects.equals(paymentId, paymentId.paymentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId);
  }
}

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
  private String itemId;

  public PaymentId(String itemId) {
    this.itemId = itemId;
  }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PaymentId paymentId = (PaymentId) o;
		return Objects.equals(itemId, paymentId.itemId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}
}

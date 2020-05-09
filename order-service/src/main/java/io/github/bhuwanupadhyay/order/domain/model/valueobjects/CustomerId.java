package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerId {

  @Column(name = "CUSTOMER_ID")
  private String customerId;

  public CustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerId that = (CustomerId) o;
    return Objects.equals(customerId, that.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId);
  }
}

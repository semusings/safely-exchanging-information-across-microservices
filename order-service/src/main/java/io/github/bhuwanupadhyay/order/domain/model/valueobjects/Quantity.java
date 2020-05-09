package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Quantity {

  @Column(name = "QUANTITY")
  private Integer quantity;

  public Quantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Quantity quantity1 = (Quantity) o;
    return Objects.equals(quantity, quantity1.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantity);
  }
}

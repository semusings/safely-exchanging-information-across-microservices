package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemPrice {

  private BigDecimal itemPrice;

  public ItemPrice(BigDecimal itemPrice) {
    this.itemPrice = itemPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemPrice itemPrice1 = (ItemPrice) o;
    return Objects.equals(itemPrice, itemPrice1.itemPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemPrice);
  }
}

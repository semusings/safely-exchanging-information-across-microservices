package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderAmount {

  @Column(name = "ORDER_AMOUNT")
  private BigDecimal amount;

  @Column(name = "ORDER_AMOUNT_CURR")
  private String currency;

  public OrderAmount(BigDecimal amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderAmount that = (OrderAmount) o;
    return Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  public String asString() {
    return this.currency + " " + this.amount.toPlainString();
  }
}

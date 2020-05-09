package io.github.bhuwanupadhyay.payment.domain.model.valueobjects;

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
public class ReceivedAmount {

  @Column(name = "RECEIVED_AMOUNT")
  private BigDecimal amount;

  @Column(name = "RECEIVED_AMOUNT_CURR")
  private String currency;

  public ReceivedAmount(BigDecimal amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReceivedAmount that = (ReceivedAmount) o;
    return Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }
}

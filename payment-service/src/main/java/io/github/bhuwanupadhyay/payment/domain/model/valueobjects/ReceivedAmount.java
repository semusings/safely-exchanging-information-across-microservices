package io.github.bhuwanupadhyay.payment.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReceivedAmount {

  private static final String SEPARATOR = " ";

  @Column(name = "RECEIVED_AMOUNT")
  private BigDecimal amount;

  @Column(name = "RECEIVED_AMOUNT_CURR")
  private String currency;

  public ReceivedAmount(String amountAsString) {
    String[] parts = amountAsString.split(SEPARATOR);
    this.currency = parts[0];
    this.amount = new BigDecimal(parts[1]);
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

  public String asString() {
    return this.currency + SEPARATOR + this.amount.toPlainString();
  }
}

package io.github.bhuwanupadhyay.payment.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderAmount {

	@Column(name = "order_amount")
	private BigDecimal amount;
	@Column(name = "order_amount_currency")
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
		return Objects.equals(amount, that.amount) &&
				Objects.equals(currency, that.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}
}

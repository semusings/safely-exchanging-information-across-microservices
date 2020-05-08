package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemPrice {

	private BigDecimal itemPrice;

	public ItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
}

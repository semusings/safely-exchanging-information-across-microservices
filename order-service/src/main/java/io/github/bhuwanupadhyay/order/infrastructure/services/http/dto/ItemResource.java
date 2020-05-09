package io.github.bhuwanupadhyay.order.infrastructure.services.http.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemResource {

	private String itemId;
	private BigDecimal price;
}

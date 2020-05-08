package io.github.bhuwanupadhyay.order.interfaces.rest.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
  private String itemId;
  private Integer quantity;
}

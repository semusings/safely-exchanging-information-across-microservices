package io.github.bhuwanupadhyay.order.interfaces.rest.dto;

import lombok.Data;

@Data
public class CreateOrderResource {
  private String itemId;
  private String customerId;
  private Integer quantity;
}

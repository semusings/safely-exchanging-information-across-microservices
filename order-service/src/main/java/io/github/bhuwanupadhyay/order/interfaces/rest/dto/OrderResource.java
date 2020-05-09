package io.github.bhuwanupadhyay.order.interfaces.rest.dto;

import lombok.Data;

@Data
public class OrderResource {

  private String orderId;
  private String itemId;
  private String customerId;
  private Integer quantity;
  private String paymentId;
  private String orderAmount;
}

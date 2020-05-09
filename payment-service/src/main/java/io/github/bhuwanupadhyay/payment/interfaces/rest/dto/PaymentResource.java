package io.github.bhuwanupadhyay.payment.interfaces.rest.dto;

import lombok.Data;

@Data
public class PaymentResource {

  private String orderId;
  private String paymentId;
  private String receivedAmount;
}

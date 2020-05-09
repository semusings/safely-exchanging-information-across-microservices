package io.github.bhuwanupadhyay.payment.domain.commands;

import lombok.Data;

@Data
public class CreatePaymentCommand {

  private String orderId;
  private String orderAmount;
}

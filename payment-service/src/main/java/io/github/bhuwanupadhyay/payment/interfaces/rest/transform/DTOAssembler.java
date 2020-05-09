package io.github.bhuwanupadhyay.payment.interfaces.rest.transform;

import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.interfaces.rest.dto.PaymentResource;

public class DTOAssembler {

  public static PaymentResource toPaymentResource(Payment payment) {
    final PaymentResource result = new PaymentResource();
    result.setOrderId(payment.getOrderId().getOrderId());
    result.setPaymentId(payment.getPaymentId().getPaymentId());
    result.setReceivedAmount(payment.getReceivedAmount().asString());
    return result;
  }
}

package io.github.bhuwanupadhyay.payment.application.internal.commandservices;

import io.github.bhuwanupadhyay.payment.domain.commands.CreatePaymentCommand;
import io.github.bhuwanupadhyay.payment.domain.model.aggregates.Payment;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.ReceivedAmount;
import io.github.bhuwanupadhyay.payment.infrastructure.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePaymentCommandService {

  private final PaymentRepository paymentRepository;

  public void createPayment(CreatePaymentCommand createPaymentCommand) {
    final PaymentId paymentId = paymentRepository.nextPaymentId();
    final Payment payment = new Payment(paymentId);
    payment.receivePayment(
        new OrderId(createPaymentCommand.getOrderId()),
        new ReceivedAmount(createPaymentCommand.getOrderAmount()));
    paymentRepository.store(payment);
  }
}

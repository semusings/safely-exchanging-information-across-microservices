package io.github.bhuwanupadhyay.payment.application.internal.outboundservices;

import io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq.PaymentEventSource;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(PaymentEventSource.class)
@RequiredArgsConstructor
public class PaymentEventPublisherService {
	private final PaymentEventSource paymentEventSource;

	@TransactionalEventListener //Attach it to the transaction of the repository operation
	public void handlePaymentReceived(Object paymentReceivedEvent) {
		paymentEventSource.createOrder().send(MessageBuilder.
				withPayload(paymentReceivedEvent).build()); //Publish the event
	}
	
}

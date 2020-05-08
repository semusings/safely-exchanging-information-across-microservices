package io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentEventSource {

	@Output("createOrder")
	MessageChannel createOrder();

}

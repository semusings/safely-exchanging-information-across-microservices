package io.github.bhuwanupadhyay.payment.interfaces.events;

import io.github.bhuwanupadhyay.schemas.PaymentReceived;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class) // Bind to the channel connection for the message
public class PaymentEventHandler {

	@StreamListener(target = Sink.INPUT) // Listen to the stream of messages on the destination
	public void receiveEvent(PaymentReceived paymentReceived) {
	}
}

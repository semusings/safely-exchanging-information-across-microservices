package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.application.internal.commandservices.CreateOrderCommandService;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderRequest;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.transform.CreateOrderCommandDTOAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final CreateOrderCommandService createOrderCommandService;

	@PostMapping
	public ResponseEntity<Mono<OrderResource>> createOrder(CreateOrderRequest request,
														   ServerWebExchange exchange) {
		OrderId orderId = createOrderCommandService.createOrder(CreateOrderCommandDTOAssembler.toCommandFromDTO(request));
		final OrderResource resource = new OrderResource();
		resource.setOrderId(orderId.getOrderId());
		return ResponseEntity.ok().body(Mono.just(resource));
	}


}

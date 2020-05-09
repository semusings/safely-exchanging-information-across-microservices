package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.application.internal.commandservices.CreateOrderCommandService;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderRequest;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResponse;
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
  public Mono<ResponseEntity<CreateOrderResponse>> createOrder(
      Mono<CreateOrderRequest> createOrderRequest, ServerWebExchange exchange) {
    return createOrderRequest
        .map(
            request ->
                createOrderCommandService.createOrder(
                    CreateOrderCommandDTOAssembler.toCommandFromDTO(request)))
        .map(
            orderId -> {
              final CreateOrderResponse result = new CreateOrderResponse();
              result.setOrderId(orderId.getOrderId());
              return ResponseEntity.ok().body(result);
            });
  }
}

package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.application.internal.commandservices.CreateOrderCommandService;
import io.github.bhuwanupadhyay.order.application.internal.queryservices.OrderQueryService;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderIdResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.transform.DTOAssembler;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrderController {

  private final CreateOrderCommandService createOrderCommandService;
  private final OrderQueryService orderQueryService;

  @PostMapping
  public Mono<ResponseEntity<OrderIdResource>> createOrder(
      @RequestBody Mono<CreateOrderResource> createOrderResourceMono) {
    return createOrderResourceMono
        .map(
            request ->
                createOrderCommandService.createOrder(DTOAssembler.toCreateOrderCommand(request)))
        .map(orderId -> ResponseEntity.ok(DTOAssembler.toOrderIdResource(orderId)));
  }

  @GetMapping
  public Mono<ResponseEntity<List<OrderResource>>> getOrders(ServerWebExchange webExchange) {
    return Mono.just(
        ResponseEntity.ok(
            orderQueryService.getOrders().stream()
                .map(DTOAssembler::toOrderResource)
                .collect(Collectors.toList())));
  }
}

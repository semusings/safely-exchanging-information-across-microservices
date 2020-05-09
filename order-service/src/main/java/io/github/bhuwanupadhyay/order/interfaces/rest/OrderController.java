package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.application.internal.commandservices.CreateOrderCommandService;
import io.github.bhuwanupadhyay.order.application.internal.queryservices.OrderQueryService;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderIdResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.transform.CreateOrderCommandDTOAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                createOrderCommandService.createOrder(
                    CreateOrderCommandDTOAssembler.toCommandFromDTO(request)))
        .map(
            orderId -> {
              final OrderIdResource result = new OrderIdResource();
              result.setOrderId(orderId.getOrderId());
              return ResponseEntity.ok().body(result);
            });
  }

  @GetMapping
  public Mono<ResponseEntity<List<OrderResource>>> getOrders(ServerWebExchange webExchange) {
    return Mono.just(
        ResponseEntity.ok(
            orderQueryService.getOrders().stream()
                .map(
                    order -> {
                      final OrderResource orderResource = new OrderResource();
                      orderResource.setOrderId(order.getOrderId().getOrderId());
                      orderResource.setItemId(order.getItemId().getItemId());
                      orderResource.setOrderAmount(order.getOrderAmount().asString());
                      if (Objects.nonNull(order.getPaymentId())) {
                        orderResource.setPaymentId(order.getPaymentId().getPaymentId());
                      }
                      orderResource.setQuantity(order.getQuantity().getQuantity());
                      return orderResource;
                    })
                .collect(Collectors.toList())));
  }
}

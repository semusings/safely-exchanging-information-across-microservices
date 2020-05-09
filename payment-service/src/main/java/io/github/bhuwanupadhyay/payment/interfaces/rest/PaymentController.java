package io.github.bhuwanupadhyay.payment.interfaces.rest;

import io.github.bhuwanupadhyay.payment.application.internal.queryservices.PaymentQueryService;
import io.github.bhuwanupadhyay.payment.interfaces.rest.dto.PaymentResource;
import io.github.bhuwanupadhyay.payment.interfaces.rest.transform.DTOAssembler;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentQueryService paymentQueryService;

  @GetMapping
  public Mono<ResponseEntity<List<PaymentResource>>> getPayments(ServerWebExchange webExchange) {
    return Mono.just(
        ResponseEntity.ok(
            paymentQueryService.getPayments().stream()
                .map(DTOAssembler::toPaymentResource)
                .collect(Collectors.toList())));
  }
}

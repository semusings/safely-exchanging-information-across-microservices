package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Disabled
class OrderControllerIntegrationTest {

  @LocalServerPort private Integer port;

  private WebTestClient client;

  @BeforeEach
  void setUp() {
    this.client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
  }

  @Test
  void testCreateOrder() {
    final CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    createOrderRequest.setItemId("01213342");
    createOrderRequest.setQuantity(10);
    this.client
        .post()
        .uri("/orders")
        .body(BodyInserters.fromValue(createOrderRequest))
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.orderId")
        .isNumber();
  }
}

package io.github.bhuwanupadhyay.order.interfaces.rest;

import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResource;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Disabled
class OrderControllerIntegrationTest {

  @LocalServerPort private Integer port;

  private WebTestClient client;
  @Autowired private List<JpaRepository> repositories;

  @BeforeEach
  void setUp() {
    this.client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
  }

  @Test
  void testCreateOrder() {
    // given
    final CreateOrderResource createOrderResource = new CreateOrderResource();
    createOrderResource.setItemId("01213342");
    createOrderResource.setQuantity(10);
    // when
    final ResponseSpec response =
        this.client.post().uri("/orders").bodyValue(createOrderResource).exchange();
    // then
    response.expectStatus().isOk().expectBody().jsonPath("$.orderId").isNotEmpty();
  }

  @Test
  void testGetOrders() {
    // given
    testCreateOrder();
    testCreateOrder();
    // when
    final ResponseSpec response = this.client.get().uri("/orders").exchange();
    // then
    response
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.length()")
        .isEqualTo(2)
        .jsonPath("$[*].orderId")
        .isNotEmpty();
  }

  @AfterEach
  void tearDown() {
    this.repositories.forEach(JpaRepository::deleteAllInBatch);
  }
}

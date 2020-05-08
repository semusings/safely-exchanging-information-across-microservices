package io.github.bhuwanupadhyay.order.interfaces.rest.transform;

import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderRequest;

public class CreateOrderCommandDTOAssembler {

  public static CreateOrderCommand toCommandFromDTO(CreateOrderRequest createOrderRequest) {
    return new CreateOrderCommand();
  }
}

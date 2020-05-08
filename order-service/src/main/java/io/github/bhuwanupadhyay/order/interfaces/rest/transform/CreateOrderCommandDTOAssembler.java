package io.github.bhuwanupadhyay.order.interfaces.rest.transform;

import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderRequest;

public class CreateOrderCommandDTOAssembler {

  public static CreateOrderCommand toCommandFromDTO(CreateOrderRequest createOrderRequest) {
    final CreateOrderCommand createOrderCommand = new CreateOrderCommand();
    createOrderCommand.setItemId(createOrderRequest.getItemId());
    createOrderCommand.setQuantity(createOrderRequest.getQuantity());
    return createOrderCommand;
  }
}

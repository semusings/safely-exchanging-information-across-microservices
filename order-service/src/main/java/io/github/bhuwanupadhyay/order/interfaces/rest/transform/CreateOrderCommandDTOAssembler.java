package io.github.bhuwanupadhyay.order.interfaces.rest.transform;

import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResource;

public class CreateOrderCommandDTOAssembler {

  public static CreateOrderCommand toCommandFromDTO(CreateOrderResource createOrderResource) {
    final CreateOrderCommand createOrderCommand = new CreateOrderCommand();
    createOrderCommand.setItemId(createOrderResource.getItemId());
    createOrderCommand.setQuantity(createOrderResource.getQuantity());
    return createOrderCommand;
  }
}

package io.github.bhuwanupadhyay.order.interfaces.rest.transform;

import io.github.bhuwanupadhyay.order.domain.commands.CreateOrderCommand;
import io.github.bhuwanupadhyay.order.domain.model.aggregates.Order;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.CreateOrderResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderIdResource;
import io.github.bhuwanupadhyay.order.interfaces.rest.dto.OrderResource;
import java.util.Objects;

public class DTOAssembler {

  public static CreateOrderCommand toCreateOrderCommand(CreateOrderResource createOrderResource) {
    final CreateOrderCommand result = new CreateOrderCommand();
    result.setItemId(createOrderResource.getItemId());
    result.setQuantity(createOrderResource.getQuantity());
    return result;
  }

  public static OrderResource toOrderResource(Order order) {
    final OrderResource result = new OrderResource();
    result.setOrderId(order.getOrderId().getOrderId());
    result.setItemId(order.getItemId().getItemId());
    result.setOrderAmount(order.getOrderAmount().asString());
    if (Objects.nonNull(order.getPaymentId())) {
      result.setPaymentId(order.getPaymentId().getPaymentId());
    }
    result.setQuantity(order.getQuantity().getQuantity());
    return result;
  }

  public static OrderIdResource toOrderIdResource(OrderId orderId) {
    final OrderIdResource result = new OrderIdResource();
    result.setOrderId(orderId.getOrderId());
    return result;
  }
}

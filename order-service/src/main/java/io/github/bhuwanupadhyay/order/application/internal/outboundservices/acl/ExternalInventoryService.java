package io.github.bhuwanupadhyay.order.application.internal.outboundservices.acl;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.ItemId;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.ItemPrice;
import io.github.bhuwanupadhyay.order.infrastructure.services.http.ExternalInventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExternalInventoryService {

  private final ExternalInventoryClient externalInventoryClient;

  public ItemPrice fetchItemPrice(ItemId itemId) {
    return new ItemPrice(BigDecimal.TEN);
  }
}

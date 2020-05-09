package io.github.bhuwanupadhyay.order.infrastructure.services.http;

import io.github.bhuwanupadhyay.order.infrastructure.services.http.dto.ItemResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExternalInventoryClient {

  public ItemResource fetchItem(String itemId) {
    final ItemResource itemResource = new ItemResource();
    itemResource.setItemId(itemId);
    itemResource.setPrice(BigDecimal.TEN);
    return itemResource;
  }
}

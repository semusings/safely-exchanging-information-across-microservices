package io.github.bhuwanupadhyay.order.application.internal.outboundservices.acl;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.ItemId;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.ItemPrice;
import io.github.bhuwanupadhyay.order.infrastructure.services.http.ExternalInventoryClient;
import io.github.bhuwanupadhyay.order.infrastructure.services.http.dto.ItemResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalInventoryService {

  private final ExternalInventoryClient externalInventoryClient;

  public ItemPrice fetchItemPrice(ItemId itemId) {
    final ItemResource itemResource = externalInventoryClient.fetchItem(itemId.getItemId());
    return toItemPrice(itemResource);
  }
  /**
   * * Anti-corruption layer conversion method from the inventory service's domain model (Item) to
   * the domain model recognized by the Order Bounded Context (ItemPrice)
   *
   * @param itemResource
   * @return
   */
  private ItemPrice toItemPrice(ItemResource itemResource) {
    return new ItemPrice(itemResource.getPrice());
  }
}

package io.github.bhuwanupadhyay.order.infrastructure.services.http.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemResource {

  private String itemId;
  private BigDecimal price;
}

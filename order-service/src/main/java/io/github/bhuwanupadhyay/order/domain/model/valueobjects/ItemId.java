package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemId {

  @Column(name = "ITEM_ID")
  private String itemId;

  public ItemId(String itemId) {
    this.itemId = itemId;
  }
}

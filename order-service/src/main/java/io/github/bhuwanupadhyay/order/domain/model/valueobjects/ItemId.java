package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemId {

  @Column(name = "ITEM_ID")
  private String itemId;

  public ItemId(String itemId) {
    this.itemId = itemId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemId itemId1 = (ItemId) o;
    return Objects.equals(itemId, itemId1.itemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId);
  }
}

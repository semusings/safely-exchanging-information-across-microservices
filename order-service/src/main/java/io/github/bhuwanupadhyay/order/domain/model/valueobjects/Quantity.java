package io.github.bhuwanupadhyay.order.domain.model.valueobjects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Quantity {

  @Column(name = "QUANTITY")
  private Integer quantity;

  public Quantity(Integer quantity) {
    this.quantity = quantity;
  }
}

package com.integration.utils.dto;

import javax.xml.bind.annotation.XmlElement;

public class PayloadDto {
  private OrderDto order;

  public OrderDto getOrder() {
    return order;
  }
  @XmlElement
  public void setOrder(OrderDto order) {
    this.order = order;
  }
}

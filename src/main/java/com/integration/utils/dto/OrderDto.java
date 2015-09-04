package com.integration.utils.dto;

import com.integration.utils.enums.EditionCodeEnum;
import com.integration.utils.enums.PricingDurationEnum;

public class OrderDto {
  private EditionCodeEnum editionCode;
  private PricingDurationEnum pricingDuration;
  
  public EditionCodeEnum getEditionCode() {
    return editionCode;
  }
  public void setEditionCode(EditionCodeEnum editionCode) {
    this.editionCode = editionCode;
  }
  public PricingDurationEnum getPricingDuration() {
    return pricingDuration;
  }
  public void setPricingDuration(PricingDurationEnum pricingDuration) {
    this.pricingDuration = pricingDuration;
  }
}

package com.integration.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.integration.utils.enums.SubscriptionTypeEnum;

@Entity
@Table(name = "subscriptions")
public class Subscription {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotNull
  private SubscriptionTypeEnum type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SubscriptionTypeEnum getType() {
    return type;
  }

  public void setType(SubscriptionTypeEnum type) {
    this.type = type;
  }
  
  
}
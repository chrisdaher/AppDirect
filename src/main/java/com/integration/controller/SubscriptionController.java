package com.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.integration.domain.entities.Subscription;
import com.integration.service.SubscriptionService;

@RestController
@RequestMapping(value = "/subscription", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubscriptionController {
  private final SubscriptionService subscriptionService;

  @Autowired
  public SubscriptionController(final SubscriptionService subscriptionService) {
    this.subscriptionService = subscriptionService;
  }
  
  @RequestMapping("/subscriptions")
  public List<Subscription> getSubscriptions() {
	return subscriptionService.getSubscriptions();
  }
}

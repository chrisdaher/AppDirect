package com.integration.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integration.service.SubscriptionService;
import com.integration.utils.dto.AppDirectResponse;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {
  private final SubscriptionService subscriptionService;

  /**
   * Instantiates a new bridge controller.
   *
   * @param bridgeService the bridge service
   */
  @Autowired
  public SubscriptionController(final SubscriptionService subscriptionService) {
    this.subscriptionService = subscriptionService;
  }
  
  @RequestMapping("/create")
  public @ResponseBody AppDirectResponse createSubscription(@QueryParam("eventUrl") final String eventUrl) {
    String id = subscriptionService.createSubscription(eventUrl);
    boolean success = (id != null);
    AppDirectResponse response = new AppDirectResponse(success,id);
    return response;
  }
}

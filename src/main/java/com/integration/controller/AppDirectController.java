package com.integration.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integration.domain.entities.Subscription;
import com.integration.service.SubscriptionService;
import com.integration.utils.dto.AppDirectResponse;

@RestController
@RequestMapping(value = "/appdirect")
public class AppDirectController {
	  private final SubscriptionService subscriptionService;

	  @Autowired
	  public AppDirectController(final SubscriptionService subscriptionService) {
	    this.subscriptionService = subscriptionService;
	  }
	  
	  @RequestMapping("/create")
	  public @ResponseBody AppDirectResponse createSubscription(@QueryParam("eventUrl") final String eventUrl) {
	    Subscription subscription = subscriptionService.createSubscription(eventUrl);
	    String id = subscription.getId().toString();
	    boolean success = (id != null);
	    AppDirectResponse response = new AppDirectResponse(success,id);
	    return response;
	  }
}

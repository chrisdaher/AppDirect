package com.integration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppDirectConfig {
  @Value("${appDirect.oauth.consumerKey}")
  private String consumerKey;
  
  @Value("${appDirect.oauth.consumerSecret}")
  private String consumerSecret;

  public String getConsumerKey() {
    return consumerKey;
  }

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }
}

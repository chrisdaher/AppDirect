package com.integration.controller;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.clients.ADAuthorizationClient;

@RestController
@RequestMapping(value = "/test/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
    private final ADAuthorizationClient adAuthClient;

    @Autowired
    public TestController(final ADAuthorizationClient authClient) {
      this.adAuthClient = authClient;
    }

    @RequestMapping("/test/{id}")
    public ResponseEntity<?> getTest(@PathVariable("id") final String id) {
      String url = "https://www.appdirect.com/api/billing/v1/subscriptions/"+id;
      try {
        adAuthClient.authenticatedGetCall(url);
      } catch (OAuthMessageSignerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (OAuthExpectationFailedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (OAuthCommunicationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return null;
    }
}

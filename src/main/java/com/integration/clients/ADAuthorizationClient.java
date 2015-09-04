package com.integration.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integration.config.AppDirectConfig;

@Component
public class ADAuthorizationClient {
  @Autowired
  private AppDirectConfig appDirectConfig;
   
  public String authenticatedGetCall(String urlPath) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException{
    String consumerKey = appDirectConfig.getConsumerKey();
    String consumerSecret = appDirectConfig.getConsumerSecret();
    OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey, consumerSecret);
    
    URL url = new URL(urlPath);
    HttpsURLConnection request = (HttpsURLConnection)url.openConnection();
    //consumer.sign(request);
    request.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
  
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
  
    //print result
    return response.toString();
  }
}

package com.integration.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.http.HTTPException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.integration.clients.ADAuthorizationClient;
import com.integration.domain.entities.Subscription;
import com.integration.domain.repositories.SubscriptionRepository;
import com.integration.utils.dto.EventDto;

@Component
@Transactional(readOnly = true)
public class SubscriptionService {
  @Autowired
  private ADAuthorizationClient client;
  
  @Autowired
  private SubscriptionRepository subscriptionRepository;
  
  public Subscription getSubscription(long id){
	  return subscriptionRepository.findOne(id);
  }
  
  public List<Subscription> getSubscriptions(){
	  return subscriptionRepository.findAll();
  }
  
  public Subscription updateSubscription(Subscription subscription){
	  if(subscription.getId() == null || subscription.getId().longValue() <= 0)
		  throw new HTTPException(404);
	  return subscriptionRepository.save(subscription);
  }
  
  @Transactional
  public Subscription createSubscription(String eventUrl){
    try {
      String response = client.authenticatedGetCall(eventUrl);
      JAXBContext context = JAXBContext.newInstance(EventDto.class);
      Unmarshaller marshal = context.createUnmarshaller();
      StringReader reader = new StringReader(response);
      EventDto event = (EventDto) marshal.unmarshal(reader);
      System.out.println("worked");
      Subscription subscription = new Subscription();
      subscription.setType(event.getType());
      return subscriptionRepository.save(subscription);
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
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;
  }
  
  
}

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
import com.integration.utils.dto.CreatorDto;
import com.integration.utils.dto.EventDto;
import com.integration.utils.dto.OrderDto;
import com.integration.utils.dto.PayloadDto;
import com.integration.utils.enums.EditionCodeEnum;
import com.integration.utils.enums.PricingDurationEnum;
import com.integration.utils.enums.SubscriptionTypeEnum;

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
  
  private Subscription eventToSubscription(EventDto event){
	  Subscription subscription = new Subscription();
      subscription.setType(event.getType());
      subscription.setEdition(event.getPayload().getOrder().getEditionCode());
      subscription.setDuration(event.getPayload().getOrder().getPricingDuration());;
      
      PayloadDto payload = event.getPayload();
      if(payload != null){
    	  OrderDto order = payload.getOrder();
    	  if(order != null){
    		  EditionCodeEnum edition = order.getEditionCode();
    		  PricingDurationEnum duration = order.getPricingDuration();
    		  
    		  subscription.setEdition(edition);
    		  subscription.setDuration(duration);
    	  }
      }
      
      CreatorDto creator = event.getCreator();
      if(creator != null){
    	  String firstName = creator.getFirstName();
    	  String lastName = creator.getLastName();
    	  String email = creator.getEmail();
    	  String uuid = creator.getUuid();
    	  
    	  subscription.setFirstName(firstName);
    	  subscription.setLastName(lastName);
    	  subscription.setEmail(email);
    	  subscription.setUuid(uuid);
      }
      return subscription;
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
     
      Subscription subscription = eventToSubscription(event);
      
      return subscriptionRepository.save(subscription);
    } catch (OAuthMessageSignerException e) {
      e.printStackTrace();
    } catch (OAuthExpectationFailedException e) {
      e.printStackTrace();
    } catch (OAuthCommunicationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    throw new HTTPException(500);
  }
  
  
}

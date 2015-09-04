package com.integration.utils.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
public class AppDirectResponse {
  private boolean success;
  private String message;
  private String accountIdentifier;
  
  public AppDirectResponse(){
    
  }
  
  public AppDirectResponse(boolean success, String accountIdentifier){
    this.success = success;
    this.accountIdentifier = accountIdentifier;
    this.message = "Account creation failed";
    if(success){
      this.message = "Account creation successfull";
    }
  }
  
  public boolean isSuccess() {
    return success;
  }
  @XmlElement
  public void setSuccess(boolean success) {
    this.success = success;
  }
  public String getMessage() {
    return message;
  }
  @XmlElement
  public void setMessage(String message) {
    this.message = message;
  }
  public String getAccountIdentifier() {
    return accountIdentifier;
  }
  @XmlElement
  public void setAccountIdentifier(String accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }
  
}

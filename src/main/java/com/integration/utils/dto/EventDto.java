package com.integration.utils.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.integration.utils.enums.SubscriptionTypeEnum;

@XmlRootElement(name="event")
public class EventDto {
	private SubscriptionTypeEnum type;
	private CreatorDto creator;
	private PayloadDto payload;

	public SubscriptionTypeEnum getType() {
		return type;
	}
	@XmlElement
	public void setType(SubscriptionTypeEnum type) {
		this.type = type;
	}

	public PayloadDto getPayload() {
		return payload;
	}
	@XmlElement
	public void setPayload(PayloadDto payload) {
		this.payload = payload;
	}
	public CreatorDto getCreator() {
		return creator;
	}
	@XmlElement
	public void setCreator(CreatorDto creator) {
		this.creator = creator;
	}
}

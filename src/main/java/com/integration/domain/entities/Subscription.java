package com.integration.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.integration.utils.enums.EditionCodeEnum;
import com.integration.utils.enums.PricingDurationEnum;
import com.integration.utils.enums.SubscriptionTypeEnum;

@Entity
@Table(name = "subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private SubscriptionTypeEnum type;

	private EditionCodeEnum edition;

	private PricingDurationEnum duration;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SubscriptionTypeEnum getType() {
		return type;
	}

	public void setType(SubscriptionTypeEnum type) {
		this.type = type;
	}

	public EditionCodeEnum getEdition() {
		return edition;
	}

	public void setEdition(EditionCodeEnum edition) {
		this.edition = edition;
	}

	public PricingDurationEnum getDuration() {
		return duration;
	}

	public void setDuration(PricingDurationEnum duration) {
		this.duration = duration;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
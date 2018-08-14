package com.psi.beans;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author kul_grace
 *
 */
public class SmsBean {
	
	private Set<String> recipients;
	
	private String message;
	
	private SmsConfigurationBean smsConfiguration;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(Set<String> recipients) {
		this.recipients = recipients;
	}

	public SmsConfigurationBean getSmsConfiguration() {
		return smsConfiguration;
	}

	public void setSmsConfiguration(SmsConfigurationBean smsConfiguration) {
		this.smsConfiguration = smsConfiguration;
	}
	
	@Override
	public String toString() {
		String recipientList = "";
		for(String r : this.recipients) {
			recipientList += r;
		}
		return "Message: " + this.getMessage() + "\n" + 
				"Sms Configuration: " + this.getSmsConfiguration().toString() + "\n" + 
				"Recipients: " + recipientList;
	}
	

}

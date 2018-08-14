package com.psi.beans;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author kul_grace
 *
 */

public class EmailHeaderBean {
	
	private String sender;
	
	private String subject;
	
	private Set<String> replyTo;
	
	private Set<String> recipients;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(Set<String> recipients) {
		this.recipients = recipients;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Set<String> getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Set<String> replyTo) {
		this.replyTo = replyTo;
	}
	
	@Override
	public String toString() {
		String replyToList = "";
		String recipientsList = "";
		for(String r : this.getReplyTo()) {
			replyToList = replyToList + r + "\n";
		}
		
		for(String r : this.getRecipients()) {
			recipientsList = recipientsList + r + "\n";
		}
		
		return "Sender: " + this.getSender() + "\n" + 
				"Subject: " + this.getSubject() + "\n" +
				"Recipients: " + recipientsList + "\n" +
				"Reply To: " + replyToList;
	}

}

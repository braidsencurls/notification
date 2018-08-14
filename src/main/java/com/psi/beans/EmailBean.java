package com.psi.beans;

import java.io.File;
import java.util.List;

/**
 * 
 * @author kul_grace
 *
 */

public class EmailBean {
	
	private EmailHeaderBean emailHeader;
	
	private String message;
	
	private String format;
	
	private EmailConfigurationBean emailConfiguration;
	
	private List<File> attachements;

	public EmailHeaderBean getEmailHeader() {
		return emailHeader;
	}

	public void setEmailHeader(EmailHeaderBean emailHeader) {
		this.emailHeader = emailHeader;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public EmailConfigurationBean getEmailConfiguration() {
		return emailConfiguration;
	}

	public void setEmailConfiguration(EmailConfigurationBean emailConfiguration) {
		this.emailConfiguration = emailConfiguration;
	}

	/**
	 * 
	 * For future Implementation
	 */

	public List<File> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<File> attachements) {
		this.attachements = attachements;
	}
	
	
	public String toString() {
		return "Email Header: " + this.getEmailHeader().toString() + "\n" +
				"Message: " + this.getMessage() + "\n" +
				"Format: " + this.getFormat() + "\n" +
				"Email Configuration: " + this.getEmailConfiguration().toString();
	}
	
}

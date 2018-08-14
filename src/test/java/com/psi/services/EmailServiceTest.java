package com.psi.services;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import com.psi.beans.EmailBean;
import com.psi.beans.EmailConfigurationBean;
import com.psi.beans.EmailHeaderBean;

public class EmailServiceTest {
	
	//@Test
	public void sendEmail() {
		EmailService service = new EmailServiceImp();
		EmailBean emailBean = new EmailBean();
		EmailConfigurationBean config = new EmailConfigurationBean();
		EmailHeaderBean header = new EmailHeaderBean();
		Properties properties = new Properties();
		
		properties.setProperty("mail.smtp.user", "");	
		properties.setProperty("mail.smtp.password", "");
		properties.setProperty("mail.smtp.auth", "false");
		properties.setProperty("mail.smtp.host", "10.9.80.113");
		properties.setProperty("mail.smtp.port", "25");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.port", "25");
		properties.setProperty("mail.smtp.ssl.enable", "false");
		properties.setProperty("mail.smtp.ssl.trust", "10.9.80.113");
		properties.setProperty("mail.smtp.socketFactory.fallback", "true");
		
		/*prop.setProperty("mail.smtp.user", "");
		prop.setProperty("mail.smtp.password", "");
		prop.setProperty("mail.smtp.auth", "false");
		prop.setProperty("mail.smtp.host", "10.9.80.113");
		prop.setProperty("mail.smtp.port", "25");
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.socketFactory.port", "25");
		prop.setProperty("mail.smtp.ssl.enable", "false");
		prop.setProperty("mail.smtp.ssl.trust", "10.9.80.113");
		prop.setProperty("mail.smtp.socketFactory.fallback", "true");*/
		
		Set<String> receipients = new HashSet<String>();
		receipients.add("grace@psi-incontrol.com");
		
		config.setSmtpPassword("");
		config.setSmtpUser("");
		
		header.setRecipients(receipients);
		header.setSender("businessdesk@psi-incontrol.com");
		header.setSubject("Test Email");
	
		emailBean.setEmailConfiguration(config);
		emailBean.setEmailHeader(header);
		emailBean.setFormat("text/html");
		emailBean.setMessage("Another Test");
		
		service.sendEmail(emailBean, properties);
		
	}

}

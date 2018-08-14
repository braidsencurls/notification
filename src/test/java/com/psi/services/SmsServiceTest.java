package com.psi.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.psi.beans.SmsBean;
import com.psi.beans.SmsConfigurationBean;

public class SmsServiceTest {
	
	//@Test
	public void sendSms() {
		SmsService smsService = new SmsServiceImp();
		SmsBean smsBean = new SmsBean();
		Set<String> recipients = new HashSet<String>();
		recipients.add("0182915546");
		
		SmsConfigurationBean smsConfig = new SmsConfigurationBean();
		smsConfig.setSmsAuth("true");
		smsConfig.setSmsLogin("http://www.infoblast.com.my/openapi/login.php");
		smsConfig.setSmsUser("vadslyfe@unifi.my");
		smsConfig.setSmsPassword("v4d51yf3");
		smsConfig.setSmsSend("http://www.infoblast.com.my/openapi/sendmsg.php");
		
		smsBean.setMessage("This is a test message");
		smsBean.setRecipients(recipients);
		smsBean.setSmsConfiguration(smsConfig);
		
		assertTrue(smsService.sendSms(smsBean));
	}
	
	/*@Test
	public void login() {
		SmsService smsService = new SmsServiceImp();
		SmsConfigurationBean smsConfig = new SmsConfigurationBean();
		smsConfig.setSmsAuth("true");
		smsConfig.setSmsLogin("http://www.infoblast.com.my/openapi/login.php");
		smsConfig.setSmsUser("vadslyfe@unifi.my");
		smsConfig.setSmsPassword("v4d51yf3");
		smsConfig.setSmsSend("http://www.infoblast.com.my/openapi/sendmsg.php");
		
		assertTrue(smsService.login(smsConfig));
	}*/

}

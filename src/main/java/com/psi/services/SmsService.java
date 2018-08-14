package com.psi.services;

import com.psi.beans.SmsBean;
import com.psi.beans.SmsConfigurationBean;

public interface SmsService {
	
	public boolean sendSms(SmsBean smsBean);
	
	public boolean login(SmsConfigurationBean smsConfigBean);
	
}

package com.psi.beans;

/**
 * 
 * @author kul_grace
 *
 */
public class SmsConfigurationBean {
	
	private String smsLogin;
	
	private String smsUser;
	
	private String smsPassword;
	
	private String smsSend;
	
	private String smsAuth;

	public String getSmsLogin() {
		return smsLogin;
	}

	public void setSmsLogin(String smsLogin) {
		this.smsLogin = smsLogin;
	}

	public String getSmsUser() {
		return smsUser;
	}

	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}

	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public String getSmsSend() {
		return smsSend;
	}

	public void setSmsSend(String smsSend) {
		this.smsSend = smsSend;
	}

	public String getSmsAuth() {
		return smsAuth;
	}

	public void setSmsAuth(String smsAuth) {
		this.smsAuth = smsAuth;
	}
	
	@Override
	public String toString() {
		return "SMS Login: " + this.getSmsLogin() + "\n" +
				"SMS User: " + this.getSmsUser() + "\n" +
				"Sms Password: " + this.getSmsPassword() + "\n" +
				"Sms Send: " + this.getSmsSend() + "\n" +
				"Sms Auth: " + this.getSmsAuth();
	}

}

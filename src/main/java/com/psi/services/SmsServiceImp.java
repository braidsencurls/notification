package com.psi.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psi.beans.SmsBean;
import com.psi.beans.SmsConfigurationBean;
import com.psi.util.CmnUtil;
import com.psi.wrappers.Rsp;

public class SmsServiceImp implements SmsService {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsServiceImp.class);

	public boolean sendSms(SmsBean smsBean) {
		SmsConfigurationBean smsConfigBean = smsBean.getSmsConfiguration();
		String message = smsBean.getMessage();
		Set<String> recipientList = smsBean.getRecipients();
		String combinedRecipients = "";
		for(String recipient : recipientList) {
			combinedRecipients = combinedRecipients + recipient + "," ;
		}
		combinedRecipients = combinedRecipients.substring(0, combinedRecipients.length() - 1);
		
		String url = smsConfigBean.getSmsSend();
		String username = smsConfigBean.getSmsUser();
		String password = smsConfigBean.getSmsPassword();
		String encryptedPassword = CmnUtil.encryptSha1(password);
		String hashKey = CmnUtil.encryptSha1(username + password + combinedRecipients);
		
		long transactionId = CmnUtil.generateTransactionId(10);
		
		try {
			String requestBody = "username=" + username + "&password=" +
					encryptedPassword + "&msgtype=text" + 
					"&message=" + message + "&to=" + combinedRecipients + 
					"&hashkey=" + hashKey + "&transcid=" + transactionId;
			
			logger.info(requestBody.toString());
			URL obj = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.writeBytes(requestBody);
			os.flush();
			os.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = "";
			StringBuffer response = new StringBuffer();
			
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			
			br.close();
			logger.info("Response: " + response.toString());
			if(!response.toString().equals("1")) {
				return false;
			}
						
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean login(SmsConfigurationBean smsConfigBean) {
		String url = smsConfigBean.getSmsLogin();
		String username = smsConfigBean.getSmsUser();
		String password = smsConfigBean.getSmsPassword();
		String encryptedPassword = CmnUtil.encryptSha1(password);
		
		try {
			String urlParameters = "username=" + username + "&password=" + encryptedPassword;
			URL obj = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.writeBytes(urlParameters);
			os.flush();
			os.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			
			Rsp rsp = JAXB.unmarshal(new StringReader(response.toString()), Rsp.class);
			logger.info(rsp.toString());
			
			if(rsp.getStatus().equalsIgnoreCase("fail")) {
				logger.info("Message sending failed. Error Description: " + rsp.getErr().getDesc());
				return false;
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Message sending failed. " + e.getMessage());
			return false;
		}
	}
}

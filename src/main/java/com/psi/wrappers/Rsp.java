package com.psi.wrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rsp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rsp {
	
	@XmlAttribute
	private String status;
	
	@XmlElement
	private String sessionid;
	
	@XmlElement
	private Err err;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Err getErr() {
		return err;
	}

	public void setErr(Err err) {
		this.err = err;
	}
	
	@Override
	public String toString() {
		return "Status: " + this.status + "\n" +
				"Error Code: " + this.getErr().getReturncode() + "\n" +
				"Error Description: " + this.getErr().getDesc();
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

}

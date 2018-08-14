package com.psi.wrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "err")
@XmlAccessorType(XmlAccessType.FIELD)
public class Err {
	
	@XmlAttribute
	private String returncode;
	
	@XmlAttribute
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

}

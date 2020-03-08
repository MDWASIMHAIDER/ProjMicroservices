package com.example.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

import lombok.Data;

@Data
@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserBinding {
	Integer serialNumber;
	private String uname;
	private String pazzword;
	private String email;
	private Long phone;
	private String countries;
	private String status;
}

package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="userregistration")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer serialNumber;
	private String uname;
	private String pazzword;
	private String email;
	private Long phone;
	private String countries;
}

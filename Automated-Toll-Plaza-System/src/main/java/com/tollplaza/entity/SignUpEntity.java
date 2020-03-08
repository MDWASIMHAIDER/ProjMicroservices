package com.tollplaza.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="signup")
public class SignUpEntity {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer signUpId;
	@Column(length=12)
	private String firstName;
	@Column(length=12)
	private String lastName;
	@Column(length=35)
	private String email;
	@Column(length=12)
	private Long phone;
	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat
	private Date dob;
	@Column(length=6)
	private String gender;
	@Column(length=6)
	private String status;
	@Column(length=8)
	private String role;
	
	
}

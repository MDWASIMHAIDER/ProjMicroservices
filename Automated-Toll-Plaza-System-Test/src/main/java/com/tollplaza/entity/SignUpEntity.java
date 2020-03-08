package com.tollplaza.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="user_signup_master")
public class SignUpEntity {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer signUpId;
	@Column(length=15)
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
	@Column(length=3)
	private String active_switch;
	@Column(length=9)
	private String status;
	@Column(length=12)
	private String role;
	@Column(length=16)
	private String pazzword;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date create_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	
	//@OneToMany(mappedBy="TagMasterEntity")
	//private Set<TagMasterEntity>tag;
	
	
}

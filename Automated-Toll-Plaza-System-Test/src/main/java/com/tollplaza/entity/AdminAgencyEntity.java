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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_agency_entity_master")
public class AdminAgencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer agencyId;
	@Column(length = 25)
	private String agencyName;
	@Column(length = 20)
	private String ownerName;
	@Column(length=6)
	private String gender;
	@Column(length = 15)
	private String city;
	@Column(length = 35)
	private String email;
	@Column(length = 12)
	private Long phone;
	@Column(length=10)
	private String status;
	@Column(length = 7)
	private Integer pin;
	@Column(length = 20)
	private String pazzword;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	@Column(length = 10)
	private String role;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date create_Date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_Date;
	@Column(length=5)
	private String active_Switch="Y";
}

package com.tollplaza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="updateentity")
public class UpdateEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer updateId;
	@Column(length=35)
	private String email;
	@Column(length=20)
	private String tempPassword;
	@Column(length=20)
	private String newPassword;
	@Column(length=20)
	private String confirmPassword;
	
	@OneToOne(targetEntity=SignUpEntity.class)
	@JoinColumn(name="signUpId")
	private SignUpEntity signUpDetails;
}

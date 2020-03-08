package com.example.user;

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
@Table(name="USERS_DETAIL_TABLE")
public class UsersDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer udid;
	
	private String address;
	
	@OneToOne(targetEntity=Users.class)
	@JoinColumn(name="user_id")
	private Users users;
}

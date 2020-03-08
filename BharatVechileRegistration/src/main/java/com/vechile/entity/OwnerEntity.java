package com.vechile.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="vechileowenerdetails12")
public class OwnerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vechile_Owner_Id;
	@Column(length=12)
	private String firstName;
	@Column(length=12)
	private String lastName;
	@Column(length=6)
	private String gender;
	@Column(length=20)
	private String email;
	@Column(length=12)
	private Long phone;
	private Date dob;
	@CreationTimestamp
	private Date create_Date;
	@UpdateTimestamp
	private Date update_Date;
	

}

package com.vechile.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
@Entity
@Table(name="vechileowneraddressdetail1")
public class AddressEntity {
	
	
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	private OwnerEntity detail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_id;
	
	
	//private int vechile_Owner_Id;//fk
	@Column(length=6)
	private Integer homeno;
	@Column(length=12)
	private String streetName;
	@Column(length=12)
	private String city;
	@Column(length=6)
	private Integer zipCode;
	@CreationTimestamp
	private Date create_Date;
	@UpdateTimestamp
	private Date update_Date;
	
}

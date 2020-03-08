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

import lombok.Data;


@Data
@Entity
@Table(name="vechileregistrationdetail")
public class RegistrationEntity {
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	private OwnerEntity detail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=6)
	private int vechile_Reg_Id;
	@Column(length=16)
	@CreationTimestamp
	private Date reg_Date;
	@Column(length=16)
	@CreationTimestamp
	private Date create_Date;
	@Column(length=16)
	@UpdateTimestamp
	private Date update_Date;
	@Column(length=18)
	private String vechile_Reg_Num;
	@Column(length=14)
	private String reg_center;
	
}

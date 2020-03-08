package com.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Tag_Master_Entity")
@IdClass(Composite2.class)
public class TagMasterEntity {
	
	@Id
	@SequenceGenerator(name = "gen5", sequenceName = "TagMaster_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator = "gen5", strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer TAG_MASTER_ID;// (PK)
	@Id
	@SequenceGenerator(name = "gen6", sequenceName = "UserMaster_TAG_ID_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator = "gen6", strategy = GenerationType.SEQUENCE)
	private Integer TAG_ID ;
	@Column(length=16)
	private String VEHICLE_REG_NUM;
	@Column(length=10)
	private String VEHICLE_TYPE;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date TAG_START_DT;
	//TODO
	private Date TAG_EXPIRY_DT;
	@Column(length=10)
	private Float TAG_BAL;
	//TODO
	@Column(length=8)
	private Integer USER_ID;//--- REFERENCES FROM USER_MASTER
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CREATE_DT;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date UPDATE_DT;
	@Column(length=20)
	private String CREATED_BY;
	@Column(length=20)
	private String UPDATED_BY;
}

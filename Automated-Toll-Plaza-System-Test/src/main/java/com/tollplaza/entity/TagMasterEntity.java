package com.tollplaza.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="TagMasterEntity")
@IdClass(CompositeIdCreation.class)
public class TagMasterEntity {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "TAG_MASTER_ID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer TAG_MASTER_ID;
	@Id
	@SequenceGenerator(name = "gen2", sequenceName = "tag_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
	private Integer TAG_ID;
	@Column(length=13)
	private String vechileRegNumber;
	@Column(length=12)
	private String vechileType;
	@CreationTimestamp
	@Column(updatable=false)
	private Date tagStartDate;
	@Column(updatable=false)
	private Date tagEndDate;
	@Column(length=8)
	private Float tagBalance;
	@Column(length=6)
	private Integer userId;
	//@UpdateTimestamp
	private Date updateDate;
	@Column(length=20)
	private String createdBy;
	@Column(length=20)
	private String updatedBy;
}

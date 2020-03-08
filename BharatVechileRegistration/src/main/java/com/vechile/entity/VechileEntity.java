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

@Entity
@Table(name="vechiledetail")
@Data
public class VechileEntity {
	
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	private OwnerEntity detail;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vechile_Id;
	@Column(length=12)
	private String vechileType;
	@Column(length=5)
	private int mfgYear;
	@Column(length=12)
	private String vechileBrand;
	@CreationTimestamp
	private Date create_Date;
	@UpdateTimestamp
	private Date update_Date;
	
	
	/* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    public Author getAuthor() {
        return author;
    }*/
}

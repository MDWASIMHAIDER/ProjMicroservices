package com.vechile.command;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.vechile.entity.OwnerEntity;

import lombok.Data;


@Data
public class VechileOwnerAddressCommand {

	//private int address_id;
	//private VechileOwnerDetailEntity detail;
	//private int vechile_Owner_Id;//fk
	private Integer homeno;
	private String streetName;
	private String city;
	private Integer zipCode;
	private Date create_Date;
	private Date update_Date;
	
}

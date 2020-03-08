package com.vechile.command;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.vechile.entity.AddressEntity;

import lombok.Data;


@Data
public class VechileDetailCommand {
	
	
	//private VechileOwnerAddressDetailsEntity detail;//fk
	//private int vechile_Owner_Id;
	private String vechileType;
	private int mfgYear;
	private String vechileBrand;
	private Date create_Date;
	private Date update_Date;
}

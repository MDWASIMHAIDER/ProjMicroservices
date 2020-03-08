package com.vechile.command;

import java.sql.Date;

import lombok.Data;

@Data
public class RegistrationCommand {
	
	//private String vechile_reg_id;
	private String reg_center;
	private Date reg_Date;
	private Date create_Date;
	private Date update_Date;
	private String vechile_Reg_Num;
}

package com.vechile.command;



import java.util.Date;


import lombok.Data;

@Data
public class VechileOwnerDetailCommand {
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Long phone;
	private Date dob;
	private Date create_Date;
	private Date update_Date;
	
}

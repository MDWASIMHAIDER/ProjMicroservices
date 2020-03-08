package com.tollplaza.command;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class TagMasterCommand {
	/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date(); */
	private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
     public static Date setDate() {

         Date currentDate = new Date();
         //System.out.println(dateFormat.format(currentDate));

         // convert date to calendar
         Calendar c = Calendar.getInstance();
         c.setTime(currentDate);

         // manipulate date
         c.add(Calendar.YEAR, 3);

         // convert calendar to date
         Date currentDate1 = c.getTime();
         System.out.println(currentDate1);

          return currentDate1;
     }
  
	private Integer TAG_MASTER_ID;
	private Integer TAG_ID;
	private String vechileRegNumber;
	private String vechileType;
	private Date tagEndDate=setDate();
	private Date tagStartDate;
	private Float tagBalance=0.0f;
	private Integer userId;
	private Date updateDate;
	private String createdBy;
	private String updatedBy;
	
}

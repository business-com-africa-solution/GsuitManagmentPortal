package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MarkerChecker {
	
	@Id
	@GeneratedValue
	private Integer checkerId;
	private String name;
	private Integer steps;
	@ManyToOne
	private UserApp chekerUserId;
	private String descrption;
	private Date createdDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updateBy;
	
	
	

}

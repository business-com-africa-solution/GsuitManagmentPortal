package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SignatureTemplate {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String signatureBody;
	private Date createdDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updateBy;
	
}

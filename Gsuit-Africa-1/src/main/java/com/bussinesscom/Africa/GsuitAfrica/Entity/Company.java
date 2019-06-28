package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Integer companyId;
	private String name;
	private String description;
	private String Logo;
	private String Address;
//	@ManyToOne
//	private SignatureTemplate signature;
//	@ManyToOne
//	private Country country;
	private Date createdDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updateBy;
	@ManyToOne
	private Package packages;
//	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public Package getPackages() {
		return packages;
	}
	public void setPackages(Package packages) {
		this.packages = packages;
	}
	
	
}

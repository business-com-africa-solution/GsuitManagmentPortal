package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Services {
	
	@Id
	@GeneratedValue
	private Integer Id;
	private Boolean signature;
	private Boolean maildelegation;
	private Boolean driveAnalysis;
	private Boolean calenderApointment;
	private Boolean emailAnalysis;
	private Boolean userManegment;
	private Boolean Hr;
	private Boolean Billing;
	
	private Date createdDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updateBy;
//	@ManyToOne
//	private Role role;
//	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Boolean getSignature() {
		return signature;
	}
	public void setSignature(Boolean signature) {
		this.signature = signature;
	}
	public Boolean getMaildelegation() {
		return maildelegation;
	}
	public void setMaildelegation(Boolean maildelegation) {
		this.maildelegation = maildelegation;
	}
	public Boolean getDriveAnalysis() {
		return driveAnalysis;
	}
	public void setDriveAnalysis(Boolean driveAnalysis) {
		this.driveAnalysis = driveAnalysis;
	}
	public Boolean getCalenderApointment() {
		return calenderApointment;
	}
	public void setCalenderApointment(Boolean calenderApointment) {
		this.calenderApointment = calenderApointment;
	}
	public Boolean getEmailAnalysis() {
		return emailAnalysis;
	}
	public void setEmailAnalysis(Boolean emailAnalysis) {
		this.emailAnalysis = emailAnalysis;
	}
	public Boolean getUserManegment() {
		return userManegment;
	}
	public void setUserManegment(Boolean userManegment) {
		this.userManegment = userManegment;
	}
	public Boolean getHr() {
		return Hr;
	}
	public void setHr(Boolean hr) {
		Hr = hr;
	}
	public Boolean getBilling() {
		return Billing;
	}
	public void setBilling(Boolean billing) {
		Billing = billing;
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
	@Override
	public String toString() {
		return "Services [Id=" + Id + ", signature=" + signature + ", maildelegation=" + maildelegation
				+ ", driveAnalysis=" + driveAnalysis + ", calenderApointment=" + calenderApointment + ", emailAnalysis="
				+ emailAnalysis + ", userManegment=" + userManegment + ", Hr=" + Hr + ", Billing=" + Billing
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updateDate=" + updateDate
				+ ", updateBy=" + updateBy + "]";
	}
	
	
	
}

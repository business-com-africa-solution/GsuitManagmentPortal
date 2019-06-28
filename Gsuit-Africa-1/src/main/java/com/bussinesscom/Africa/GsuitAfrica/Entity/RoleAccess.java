package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RoleAccess {

	@Id
	@GeneratedValue
	private Integer Id;
	private Boolean signature;
	private Boolean createSignature;
	private Boolean updateSignature;
	private Boolean deleteSignature;
	private Boolean maildelegation;
	private Boolean createMailDelegation;
	private Boolean updateMailDelegation;
	private Boolean deleteMailDelegation;
	private Boolean driveAnalysis;
	private Boolean createDriveAnalysis;
	private Boolean updateDriveAnalysis;
	private Boolean deleteDriveAnalysis;
	private Boolean calenderApointment;
	private Boolean createCalenderApointment;
	private Boolean updateCalenderApointment;
	private Boolean deleteCalenderApointment;
	private Boolean emailAnalysis;
	private Boolean createEmailAnalysis;
	private Boolean updateEmailAnalysis;
	private Boolean deleteEmailAnalysis;
	private Boolean userManegment;
	private Boolean createUserManagment;
	private Boolean updateUserManagment;
	private Boolean deleteUserManagment;
	private Boolean Hr;
	private Boolean createHr;
	private Boolean updateHr;
	private Boolean deleteHr;
	private Boolean Billing;
	private Boolean createBilling;
	private Boolean updateBilling;
	private Boolean deleteBilling;
	private Date createdDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updateBy;
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
	public Boolean getCreateSignature() {
		return createSignature;
	}
	public void setCreateSignature(Boolean createSignature) {
		this.createSignature = createSignature;
	}
	public Boolean getUpdateSignature() {
		return updateSignature;
	}
	public void setUpdateSignature(Boolean updateSignature) {
		this.updateSignature = updateSignature;
	}
	public Boolean getDeleteSignature() {
		return deleteSignature;
	}
	public void setDeleteSignature(Boolean deleteSignature) {
		this.deleteSignature = deleteSignature;
	}
	public Boolean getMaildelegation() {
		return maildelegation;
	}
	public void setMaildelegation(Boolean maildelegation) {
		this.maildelegation = maildelegation;
	}
	public Boolean getCreateMailDelegation() {
		return createMailDelegation;
	}
	public void setCreateMailDelegation(Boolean createMailDelegation) {
		this.createMailDelegation = createMailDelegation;
	}
	public Boolean getUpdateMailDelegation() {
		return updateMailDelegation;
	}
	public void setUpdateMailDelegation(Boolean updateMailDelegation) {
		this.updateMailDelegation = updateMailDelegation;
	}
	public Boolean getDeleteMailDelegation() {
		return deleteMailDelegation;
	}
	public void setDeleteMailDelegation(Boolean deleteMailDelegation) {
		this.deleteMailDelegation = deleteMailDelegation;
	}
	public Boolean getDriveAnalysis() {
		return driveAnalysis;
	}
	public void setDriveAnalysis(Boolean driveAnalysis) {
		this.driveAnalysis = driveAnalysis;
	}
	public Boolean getCreateDriveAnalysis() {
		return createDriveAnalysis;
	}
	public void setCreateDriveAnalysis(Boolean createDriveAnalysis) {
		this.createDriveAnalysis = createDriveAnalysis;
	}
	public Boolean getUpdateDriveAnalysis() {
		return updateDriveAnalysis;
	}
	public void setUpdateDriveAnalysis(Boolean updateDriveAnalysis) {
		this.updateDriveAnalysis = updateDriveAnalysis;
	}
	public Boolean getDeleteDriveAnalysis() {
		return deleteDriveAnalysis;
	}
	public void setDeleteDriveAnalysis(Boolean deleteDriveAnalysis) {
		this.deleteDriveAnalysis = deleteDriveAnalysis;
	}
	public Boolean getCalenderApointment() {
		return calenderApointment;
	}
	public void setCalenderApointment(Boolean calenderApointment) {
		this.calenderApointment = calenderApointment;
	}
	public Boolean getCreateCalenderApointment() {
		return createCalenderApointment;
	}
	public void setCreateCalenderApointment(Boolean createCalenderApointment) {
		this.createCalenderApointment = createCalenderApointment;
	}
	public Boolean getUpdateCalenderApointment() {
		return updateCalenderApointment;
	}
	public void setUpdateCalenderApointment(Boolean updateCalenderApointment) {
		this.updateCalenderApointment = updateCalenderApointment;
	}
	public Boolean getDeleteCalenderApointment() {
		return deleteCalenderApointment;
	}
	public void setDeleteCalenderApointment(Boolean deleteCalenderApointment) {
		this.deleteCalenderApointment = deleteCalenderApointment;
	}
	public Boolean getEmailAnalysis() {
		return emailAnalysis;
	}
	public void setEmailAnalysis(Boolean emailAnalysis) {
		this.emailAnalysis = emailAnalysis;
	}
	public Boolean getCreateEmailAnalysis() {
		return createEmailAnalysis;
	}
	public void setCreateEmailAnalysis(Boolean createEmailAnalysis) {
		this.createEmailAnalysis = createEmailAnalysis;
	}
	public Boolean getUpdateEmailAnalysis() {
		return updateEmailAnalysis;
	}
	public void setUpdateEmailAnalysis(Boolean updateEmailAnalysis) {
		this.updateEmailAnalysis = updateEmailAnalysis;
	}
	public Boolean getDeleteEmailAnalysis() {
		return deleteEmailAnalysis;
	}
	public void setDeleteEmailAnalysis(Boolean deleteEmailAnalysis) {
		this.deleteEmailAnalysis = deleteEmailAnalysis;
	}
	public Boolean getUserManegment() {
		return userManegment;
	}
	public void setUserManegment(Boolean userManegment) {
		this.userManegment = userManegment;
	}
	public Boolean getCreateUserManagment() {
		return createUserManagment;
	}
	public void setCreateUserManagment(Boolean createUserManagment) {
		this.createUserManagment = createUserManagment;
	}
	public Boolean getUpdateUserManagment() {
		return updateUserManagment;
	}
	public void setUpdateUserManagment(Boolean updateUserManagment) {
		this.updateUserManagment = updateUserManagment;
	}
	public Boolean getDeleteUserManagment() {
		return deleteUserManagment;
	}
	public void setDeleteUserManagment(Boolean deleteUserManagment) {
		this.deleteUserManagment = deleteUserManagment;
	}
	public Boolean getHr() {
		return Hr;
	}
	public void setHr(Boolean hr) {
		Hr = hr;
	}
	public Boolean getCreateHr() {
		return createHr;
	}
	public void setCreateHr(Boolean createHr) {
		this.createHr = createHr;
	}
	public Boolean getUpdateHr() {
		return updateHr;
	}
	public void setUpdateHr(Boolean updateHr) {
		this.updateHr = updateHr;
	}
	public Boolean getDeleteHr() {
		return deleteHr;
	}
	public void setDeleteHr(Boolean deleteHr) {
		this.deleteHr = deleteHr;
	}
	public Boolean getBilling() {
		return Billing;
	}
	public void setBilling(Boolean billing) {
		Billing = billing;
	}
	public Boolean getCreateBilling() {
		return createBilling;
	}
	public void setCreateBilling(Boolean createBilling) {
		this.createBilling = createBilling;
	}
	public Boolean getUpdateBilling() {
		return updateBilling;
	}
	public void setUpdateBilling(Boolean updateBilling) {
		this.updateBilling = updateBilling;
	}
	public Boolean getDeleteBilling() {
		return deleteBilling;
	}
	public void setDeleteBilling(Boolean deleteBilling) {
		this.deleteBilling = deleteBilling;
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

//	@ManyToOne
//	private Role role;
//	
	
	

}

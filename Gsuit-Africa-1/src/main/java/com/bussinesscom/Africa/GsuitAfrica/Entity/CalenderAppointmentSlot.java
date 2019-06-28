package com.bussinesscom.Africa.GsuitAfrica.Entity;

import javax.persistence.*;

@Entity
public class CalenderAppointmentSlot {
	
	@Id
	private String id;
	private Integer companyId;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	private Boolean appointmentActive;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Boolean getAppointmentActive() {
		return appointmentActive;
	}
	public void setAppointmentActive(Boolean appointmentActive) {
		this.appointmentActive = appointmentActive;
	}
	

}

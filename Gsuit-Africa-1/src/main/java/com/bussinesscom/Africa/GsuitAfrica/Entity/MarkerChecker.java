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
	public Integer getCheckerId() {
		return checkerId;
	}
	public void setCheckerId(Integer checkerId) {
		this.checkerId = checkerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSteps() {
		return steps;
	}
	public void setSteps(Integer steps) {
		this.steps = steps;
	}
	public UserApp getChekerUserId() {
		return chekerUserId;
	}
	public void setChekerUserId(UserApp chekerUserId) {
		this.chekerUserId = chekerUserId;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
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
		return "MarkerChecker [checkerId=" + checkerId + ", name=" + name + ", steps=" + steps + ", chekerUserId="
				+ chekerUserId + ", descrption=" + descrption + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
	
	
	
	
	

}

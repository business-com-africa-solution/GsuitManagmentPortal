package com.bussinesscom.Africa.GsuitAfrica.Model;

import com.google.api.client.util.DateTime;

public class MyDriveFiles {

	private String id;
	private String fileName;
	private String createdDate;
	private String mordifiedDate;
	private String sharedWithEmailAdress;
	private String owner;

	public MyDriveFiles() {
	}

	public MyDriveFiles(String id, String fileName, String createdDate, String mordifiedDate, String owner) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.createdDate = createdDate;
		this.mordifiedDate = mordifiedDate;
		this.owner = owner;
	}
	
	public MyDriveFiles(String id, String fileName, String createdDate, String mordifiedDate,String sharedWithEmailAdress, String owner) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.createdDate = createdDate;
		this.mordifiedDate = mordifiedDate;
		this.sharedWithEmailAdress=sharedWithEmailAdress;
		this.owner = owner;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getMordifiedDate() {
		return mordifiedDate;
	}

	public void setMordifiedDate(String mordifiedDate) {
		this.mordifiedDate = mordifiedDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "MyDriveFiles [id=" + id + ", fileName=" + fileName + ", createdDate=" + createdDate + ", mordifiedDate="
				+ mordifiedDate + ", owner=" + owner + "]";
	}

	public String getSharedWithEmailAdress() {
		return sharedWithEmailAdress;
	}

	public void setSharedWithEmailAdress(String sharedWithEmailAdress) {
		this.sharedWithEmailAdress = sharedWithEmailAdress;
	}

	
	
}

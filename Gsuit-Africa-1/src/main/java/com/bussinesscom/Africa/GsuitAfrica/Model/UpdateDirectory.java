package com.bussinesscom.Africa.GsuitAfrica.Model;

public class UpdateDirectory {
	
	private String id;
	private String givenName;
	private String fullname;
	private String familyname;
	private String emailAdress;
	private String imageUrl;
	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "UpdateDirectory [id=" + id + ", givenName=" + givenName + ", fullname=" + fullname + ", familyname="
				+ familyname + ", emailAdress=" + emailAdress + ", imageUrl=" + imageUrl + "]";
	}
	
	

}

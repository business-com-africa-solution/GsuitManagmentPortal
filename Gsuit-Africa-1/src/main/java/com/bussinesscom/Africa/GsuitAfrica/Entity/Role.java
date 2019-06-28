package com.bussinesscom.Africa.GsuitAfrica.Entity;

import javax.persistence.*;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CREATED_ON")
    private Long createdOn;
    @Column(name = "MODIFIED_ON")
    private Long modifiedOn;
   
    @ManyToOne
	private RoleAccess roleAcess;   
    @ManyToOne
	private MarkerChecker markerchcker;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}
	public Long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public RoleAccess getRoleAcess() {
		return roleAcess;
	}
	public void setRoleAcess(RoleAccess roleAcess) {
		this.roleAcess = roleAcess;
	}
	public MarkerChecker getMarkerchcker() {
		return markerchcker;
	}
	public void setMarkerchcker(MarkerChecker markerchcker) {
		this.markerchcker = markerchcker;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", roleAcess=" + roleAcess + ", markerchcker=" + markerchcker + "]";
	}
	
	


    
}

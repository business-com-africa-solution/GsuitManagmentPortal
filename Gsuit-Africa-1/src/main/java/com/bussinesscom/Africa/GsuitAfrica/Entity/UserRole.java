package com.bussinesscom.Africa.GsuitAfrica.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	@GeneratedValue
	private Integer Id;
	@ManyToOne
	private UserApp userApp;
	@ManyToOne
	private Role role;

}

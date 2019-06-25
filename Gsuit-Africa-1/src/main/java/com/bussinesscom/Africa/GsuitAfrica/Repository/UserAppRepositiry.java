package com.bussinesscom.Africa.GsuitAfrica.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;


public interface UserAppRepositiry extends JpaRepository<UserApp, String>{

	
	UserApp findByEmail(String userId);

	

}

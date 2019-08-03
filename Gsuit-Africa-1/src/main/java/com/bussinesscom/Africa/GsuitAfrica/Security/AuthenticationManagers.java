package com.bussinesscom.Africa.GsuitAfrica.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;

@Configuration
public class AuthenticationManagers implements AuthenticationManager {

	
	@Autowired
	AuthenticationManagers authm;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		UserApp userDetails=new UserApp();
		authm.authenticate(authentication);
		
		return null;
	
	}

	
	
	
	
}

package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussinesscom.Africa.GsuitAfrica.Utils.ServiceResponse;

@RestController

@CrossOrigin(origins = "http://localhost:8080")
public class UserManagmentRest {

	
	
	@PostMapping("createUserApi")
	public ServiceResponse getTesting(@RequestBody String newEmployee) throws IOException, GeneralSecurityException 
	{
		System.out.println("UserSettings");
		Object appointment=newEmployee;
		ServiceResponse response=new ServiceResponse();
		response.setStatus("success");
		response.setData(appointment);
		return response;
	}
}

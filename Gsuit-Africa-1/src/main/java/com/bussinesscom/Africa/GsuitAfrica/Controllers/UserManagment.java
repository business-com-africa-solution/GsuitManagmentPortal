package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.UserName;

@Controller
public class UserManagment {

	@RequestMapping("usermanagment")
	public String getUserManagmentPage(Model model) throws IOException 
	{
	    List<User> users = new ArrayList<User>();
        User us=new User();
        us.setId("11111111111111");
        us.setPrimaryEmail("test@gmail.com");
        us.setName(new UserName().setFullName("Edwin Test"));
        us.setIsAdmin(true);
        users.add(us);
        User us2=new User();
        us2.setId("2222222222222");
        us2.setPrimaryEmail("test2@gmail.com");
        us2.setName(new UserName().setFullName("Edwin Test Two"));
        us2.setIsAdmin(true);
        users.add(us2);
        
         
        if (users == null || users.size() == 0) {
            System.out.println("No users found.");
        } else {
        	model.addAttribute("users",users);	
            System.out.println("Users:");
            for (User user : users) {
            	
            }
        }
        
		return "orgusers";
	}
	
	@RequestMapping("viewProfile/{userId}")
	public String getUserProfile(@PathVariable("userId") String userId,Model model) throws IOException 
	{
		
		model.addAttribute("image", "/jMega avax.faces.resource/images/profile.jpeg?ln=california-layout");
		model.addAttribute("domain","dk.businesscom.com");
		System.out.println("--------===+++------ "+userId);
		
		return "userprofile.html";
		
	}
	
	
	
	
	
	
	
	
}

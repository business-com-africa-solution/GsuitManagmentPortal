package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bussinesscom.Africa.GsuitAfrica.Model.UpdateDirectory;
import com.bussinesscom.Africa.GsuitAfrica.Model.myUser;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.ContactApiService;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.Utilities;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.UserName;
import com.google.api.services.iam.v1.model.ServiceAccount;
import com.google.gdata.util.ServiceException;




@Controller
public class UserManagment {

	Directory serviceDirect;
	List<User> users;
	
	@RequestMapping("usermanagment")
	public String getUserManagmentPage(Model model) throws IOException, GeneralSecurityException, URISyntaxException 
	{
		serviceDirect=SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");	
		
		com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
                .setCustomer("my_customer")
                .setMaxResults(10)
                .setOrderBy("email")
                .execute();
				
        users = result.getUsers(); 
        
        model.addAttribute("users",users);
        
		return "orgusers";
	}
	
	@RequestMapping(value="viewProfile/{userId}", method=RequestMethod.GET)
	public String getUserProfile(@PathVariable("userId") String userId,Model model) throws IOException 
	{
		
		model.addAttribute("image", "/jMega avax.faces.resource/images/profile.jpeg?ln=california-layout");
		model.addAttribute("domain","dk.businesscom.com");	
		
		for(int a=0;a<users.size();a++) {
			if(users.get(a).getId().equals(userId)) {
				
				String [] email=users.get(a).getPrimaryEmail().split("@");
				System.out.println("Id------------"+userId);
				System.out.println("Email------------"+users.get(a).getPrimaryEmail());		
				model.addAttribute("familyName",users.get(a).getName().getFamilyName());
				model.addAttribute("givenName",users.get(a).getName().getGivenName());
				model.addAttribute("emailName",email[0]);
				model.addAttribute("id", userId);
				UpdateDirectory dataUpdate=new UpdateDirectory();
				dataUpdate.setId(userId);
				model.addAttribute("updateuser",dataUpdate);
				
			}	
		}
		
		
		
		
		
		return "userprofile.html";
		
	}
	
	@RequestMapping("deleteUser/{userId}")
	public String getdelete(@PathVariable("userId") String userId,Model model) throws IOException, GeneralSecurityException, URISyntaxException 
	{
		
		model.addAttribute("image", "/jMega avax.faces.resource/images/profile.jpeg?ln=california-layout");
		model.addAttribute("domain","dk.businesscom.com");
		
		for(int a=0;a<users.size();a++) {
			if(users.get(a).getId().equals(userId)) {
				System.out.println("Id------------"+userId);
				System.out.println("Email------------"+users.get(a).getPrimaryEmail());
				serviceDirect.users().delete(users.get(a).getPrimaryEmail()).execute();
			}	
		}
		return "redirect:/usermanagment";
		
	}
	
	
	@RequestMapping(value="createUser" ,method=RequestMethod.GET)
	public String getCreateUser(Model model) throws IOException, GeneralSecurityException, URISyntaxException 
	{
		
		model.addAttribute("image", "/jMega avax.faces.resource/images/profile.jpeg?ln=california-layout");
		model.addAttribute("domain","dk.businesscom.com");	
		myUser user = new myUser();  
		model.addAttribute("myUser", user);
		return "userregisteration";
		
	}
	
	@RequestMapping(value="userRegistrations" ,method=RequestMethod.POST)
	public String getSubmitUser(@ModelAttribute(value="myUser") myUser myuser,Model model) throws IOException, GeneralSecurityException, URISyntaxException 
	{
		
		model.addAttribute("image", "/jMega avax.faces.resource/images/profile.jpeg?ln=california-layout");
		model.addAttribute("domain","dk.businesscom.com");	

		
		User users=new User();
		users.setChangePasswordAtNextLogin(true);
		
		UserName names=new UserName();
		names.setFamilyName(""+myuser.getFamilyName());
		names.setGivenName(""+myuser.getOtherName());
		names.setFullName(""+myuser.getFamilyName()+" "+myuser.getOtherName());	
		users.setName(names);
		
		users.setPrimaryEmail(myuser.getEmailName()+"@dev.businesscom.dk");
		String password=myuser.getDefaultPassword();
		users.setPassword(password);	
		
		User succeessMessage=serviceDirect.users().insert(users).execute();
		System.out.println("Succeess Message ------------- "+succeessMessage);
		
		return "redirect:/usermanagment";
		
	}
	
	
	@RequestMapping(value = "/processUpdateForm", method=RequestMethod.POST)
	public String upDateUserInformation(@ModelAttribute(value="updateuser") UpdateDirectory dataUpdate) throws IOException {
		
		 User userx=new User();
		 UserName names=new UserName();
		 names.setFamilyName(dataUpdate.getFamilyname());
		 names.setGivenName(dataUpdate.getGivenName());
		 names.setFullName(dataUpdate.getFullname());
		 userx.setPrimaryEmail(dataUpdate.getEmailAdress()+"@dev.businesscom.dk");
		 
		 userx.setName(names);
		 
		 System.out.println("USERS ID------------"+dataUpdate.getId());
		 
		 System.out.println("USERS------------"+dataUpdate.getEmailAdress());
		 
		 try {
			User user=serviceDirect.users().update(dataUpdate.getId(), userx).execute();
			System.out.println("USERS------------"+user.toString());
			System.out.println("Eliases------------"+user.getAliases());
			 
			 
			if(user!=null&&Utilities.getNullStringList(user.getAliases())!=0) 
			{
				ContactApiService.ContactService("edwin@dev.businesscom.dk", user.getAliases().get(0));
			}
			return "redirect:/usermanagment";
		} catch (IOException | GeneralSecurityException | URISyntaxException | ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

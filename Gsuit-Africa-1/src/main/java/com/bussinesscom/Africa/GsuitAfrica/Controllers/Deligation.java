package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Domain;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Model.UpdateDirectory;
import com.bussinesscom.Africa.GsuitAfrica.Repository.DomainRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Delegate;
import com.google.api.services.gmail.model.ListDelegatesResponse;
import com.google.api.services.gmail.model.Profile;

@Controller
public class Deligation {
	
	Directory serviceDirect;
	Gmail serviceGmail;
	List<User> users;
	
	@Autowired
	UserAppRepositiry userrepo;
	
	@Autowired
	DomainRepository domainRepositry;
	
	@RequestMapping("Delegation/{userId}")
	public String AccountDeligation(@PathVariable("userId") String userId, Model model,final HttpServletRequest request) throws GeneralSecurityException, IOException, URISyntaxException 
	{
		
		Optional<UserApp> user=userrepo.findById(userId);
		String loginEmail=user.get().getEmail();
		String[] domain=loginEmail.split("@");
		Domain userDomain= domainRepositry.findByDomainName(domain[1]);
		Company comp=userDomain.getCompany();
		comp.getPackages();	
		model.addAttribute("servicesAcess",comp.getPackages().getServices());
		model.addAttribute("package",comp.getPackages().getName());
		 model.addAttribute("userName", ""+user.get().getLastName()+" "+user.get().getFirstName());		
		 model.addAttribute("image", ""+user.get().getImageUrl()+"?ln=california-layout");
		
		
			serviceDirect=SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");	
			
			com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
	                .setCustomer("my_customer")
	                .setMaxResults(10)
	                .setOrderBy("email")
	                .execute();
					
	        users = result.getUsers(); 
	        
        model.addAttribute("users",users);
		
		return "accountdeligation";
	}
	
	
	@RequestMapping("DelegateAccount/{delegateId}")
	public String AccountToDeligation(@PathVariable("delegateId") String delegateId, Model model,final HttpServletRequest request) throws GeneralSecurityException, IOException, URISyntaxException 
	{
		
		String[] myId=delegateId.split("lg");
		
		Optional<UserApp> meUser=userrepo.findById(myId[1]);
		
		String loginEmail=meUser.get().getEmail();
		String[] domain=loginEmail.split("@");
		Domain userDomain= domainRepositry.findByDomainName(domain[1]);
		Company comp=userDomain.getCompany();
		comp.getPackages();	
		model.addAttribute("servicesAcess",comp.getPackages().getServices());
		model.addAttribute("package",comp.getPackages().getName());
		model.addAttribute("userName", ""+meUser.get().getLastName()+" "+meUser.get().getFirstName());		
		model.addAttribute("image", ""+meUser.get().getImageUrl()+"?ln=california-layout");
		model.addAttribute("userId", ""+myId[1]);
		
		
		
		
		
		Optional<UserApp> user=userrepo.findById(myId[0]);		
		String delegateEmail=user.get().getEmail();
		String imageurl=user.get().getImageUrl();
		String username=user.get().getUsername();
		UpdateDirectory dataUpdate=new UpdateDirectory();
		
		dataUpdate.setId(myId[1]);
		System.out.println("User email-----------------"+delegateEmail);
		model.addAttribute("familyName",user.get().getFirstName());
		model.addAttribute("delusername",username);
		model.addAttribute("delimage", imageurl);
		model.addAttribute("jobtitle", "Developer");
		model.addAttribute("delemail",delegateEmail);
		model.addAttribute("id", delegateId);
		
		model.addAttribute("updateuser",dataUpdate);
		List<String> names=new ArrayList<String>();
		names.add("E");
		names.add("s");
		names.add("c");
		names.add("d");
		names.add("g");
			
		model.addAttribute("list",names);
				
		if(user.isPresent()) 
		{
			serviceGmail=SercicesAccounts.getGmailService(delegateEmail);
			ListDelegatesResponse deligateData=serviceGmail.users().settings().delegates().list(delegateEmail).execute();	
			List<Delegate> deleligates=deligateData.getDelegates();		
			model.addAttribute("deligateList",deleligates);	
		}
		
		
		return "deligationform";
		
	}
	
	@RequestMapping(value = "processDeligationForm/{Id}", method=RequestMethod.POST)
	public String processDeligationForm(@PathVariable("Id") String Id,@ModelAttribute(value="updateuser") UpdateDirectory dataUpdate) throws IOException, GeneralSecurityException, URISyntaxException {
		
		String[] myId=Id.split("lg");
		String userAppId=myId[1];
		String delegatedAccountId=myId[0];
		
		Optional<UserApp> user=userrepo.findById(myId[0]);
		System.out.println("EMAIL Person----"+user.get().getEmail());
		
		String emailAdress=((dataUpdate.getEmailAdress()).toLowerCase()).replaceAll("\\s+", "");
		System.out.println("EMAIL Delegate----"+emailAdress);
		
		serviceGmail=SercicesAccounts.getGmailService(user.get().getEmail());
//		
		Delegate deligation=new Delegate();
		deligation.setDelegateEmail(emailAdress);
//		
		serviceGmail.users().settings().delegates().create(user.get().getEmail(), deligation).execute();
//		Profile pro=serviceGmail.users().getProfile((emailAdress)).execute();
//		System.out.println("serviceGmail-----"+pro.getMessagesTotal());
////		
		return "redirect:/DelegateAccount/"+userAppId;
		
	}
	
	
	@RequestMapping(value = "RemoveDelegateAccount/{Id}", method=RequestMethod.GET)
	public String RemoveDelegateAccount(@PathVariable("Id") String Id) throws IOException, GeneralSecurityException, URISyntaxException {
		
		String[] myId=Id.split("lg");
		String emailToRemove=myId[0];
		String delegateccount=myId[1];
		String updateId=myId[2];
		
		Optional<UserApp> user=userrepo.findById(delegateccount);
//		System.out.println("EMAIL Person----"+user.get().getEmail());
//		
//		String emailAdress=((dataUpdate.getEmailAdress()).toLowerCase()).replaceAll("\\s+", "");
//		System.out.println("EMAIL Delegate----"+emailAdress);
		
		serviceGmail=SercicesAccounts.getGmailService(user.get().getEmail());
////		
//		Delegate deligation=new Delegate();
//		deligation.setDelegateEmail(emailAdress);
////		
		serviceGmail.users().settings().delegates().delete(user.get().getEmail(), emailToRemove).execute();
//		Profile pro=serviceGmail.users().getProfile((emailAdress)).execute();
//		System.out.println("serviceGmail-----"+pro.getMessagesTotal());
////		
		return "redirect:/DelegateAccount/"+delegateccount+"lg"+updateId;
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
}

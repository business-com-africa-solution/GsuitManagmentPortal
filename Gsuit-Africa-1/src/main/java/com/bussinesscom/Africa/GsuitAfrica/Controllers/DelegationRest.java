package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bussinesscom.Africa.GsuitAfrica.AutoComplet.DataTest;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Country;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.User;

@RestController
public class DelegationRest {

	
	
	
	
	
	@RequestMapping("/search")
	public @ResponseBody List searchPost(@RequestParam("term") String query) {

	    List<Object> retVal = getListOfObjectFromDbBasedOnQuery(query);

	    return retVal;
	}

	private List<Object> getListOfObjectFromDbBasedOnQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@RequestMapping("getData")
	public  List<com.google.api.services.admin.directory.model.User>  getData() throws GeneralSecurityException, IOException, URISyntaxException {

		Directory serviceDirect=SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");	
		
		com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
                .setCustomer("my_customer")
                .setMaxResults(10)
                .setOrderBy("email")
                .execute();
				
        List<com.google.api.services.admin.directory.model.User> users = result.getUsers(); 
         
	    return users;
	}
	
	
	
	
}

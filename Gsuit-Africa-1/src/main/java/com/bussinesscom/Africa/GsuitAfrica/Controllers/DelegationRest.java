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
import com.google.api.services.drive.Drive;

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
	public  List<DataTest> getData() throws GeneralSecurityException, IOException, URISyntaxException {

		Drive driveServiceAccount=SercicesAccounts.getDriveService("edwin@dev.businesscom.dk");
		
		  
		com.google.api.services.drive.model.About about=driveServiceAccount.about().get().setFields("*").execute();
//		 System.out.println("Current user name: " + about.getKind());
//	      System.out.println("Root folder ID: " + about.getUser().getPhotoLink());
//	      System.out.println("Total quota (bytes): " + about.getStorageQuota().getUsage());
//	      System.out.println("Used quota in drive(bytes): " + about.getStorageQuota().getUsageInDrive());
//	      System.out.println("Used quota in drive(bytes): " + about.getStorageQuota().getUsageInDriveTrash());

	      String usersdata=String.valueOf(about.getStorageQuota().getUsage()/1000);
	      String usersDRIVE=String.valueOf(about.getStorageQuota().getUsageInDrive()/1000);
	      String DriveTrash=String.valueOf(about.getStorageQuota().getUsageInDriveTrash()/1000);
	      System.out.println("Used quota in drive(MB) Converted: " + usersdata);
	      System.out.println("Used usersDRIVE in drive(MB) Converted: " + usersDRIVE);
	      System.out.println("Used DriveTrash in drive(MB) Converted: " + DriveTrash);

		List<DataTest> data=new ArrayList<DataTest>();
//		data.add(new DataTest("USAGE",Double.parseDouble(usersdata)));
		data.add(new DataTest("DRIVE ",Double.parseDouble(usersDRIVE)));
		data.add(new DataTest("DRIVE TRASH",Double.parseDouble(DriveTrash)));
		
		
		   
	    return data;
	}
	
	
	
	
}

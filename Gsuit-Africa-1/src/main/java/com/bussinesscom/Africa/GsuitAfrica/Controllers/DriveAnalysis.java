package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussinesscom.Africa.GsuitAfrica.AutoComplet.DataTest;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.About;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.Gmail.Users.Messages;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.auth.ServiceAccountSigner;

@Controller
public class DriveAnalysis {
	
	@Autowired
	UserAppRepositiry userappRepo;
	
	Drive driveServiceAccount;
	Gmail gmailAnlysisService;
	
	@RequestMapping("DriveAnalysis/{userId}")
	public String driveAnalysisPage(@PathVariable("userId") String userId,Model model) throws GeneralSecurityException, IOException, URISyntaxException 
	{
//		
		System.out.println("UserId"+userId);
		Optional<UserApp> user= userappRepo.findById(userId);
		System.out.println("User------------"+user.get().getEmail());
//		
		
		driveServiceAccount=SercicesAccounts.getDriveService(user.get().getEmail());
		
		
		gmailAnlysisService=SercicesAccounts.getGmailService(user.get().getEmail());
		
		
		
		ListMessagesResponse mess=gmailAnlysisService.users().messages().list("me").execute();
		
		List<Message> messageList=mess.getMessages();
		List<String> lablesList=messageList.get(0).getLabelIds();
//		for()
		System.out.println("Lables------------------"+lablesList);
		
		
		
//		
//		  
		com.google.api.services.drive.model.About about=driveServiceAccount.about().get().setFields("*").execute();
		 System.out.println("Current user name: " + about.getKind());
	      System.out.println("Root folder ID: " + about.getUser().getPhotoLink());
	      System.out.println("Total quota (bytes): " + about.getStorageQuota().getUsage());
	      System.out.println("Used quota in drive(bytes): " + about.getStorageQuota().getUsageInDrive());
		
	      String usersdata=String.valueOf(about.getStorageQuota().getUsage()/1000);
	      String usersDRIVE=String.valueOf(about.getStorageQuota().getUsageInDrive()/1000);
	      String DriveTrash=String.valueOf(about.getStorageQuota().getUsageInDriveTrash()/1000);
	      System.out.println("Used quota in drive(MB) Converted: " + usersdata);
	      System.out.println("Used usersDRIVE in drive(MB) Converted: " + usersDRIVE);
	      System.out.println("Used DriveTrash in drive(MB) Converted: " + DriveTrash);

		List<DataTest> data=new ArrayList<DataTest>();
//		data.add(new DataTest("USAGE",Double.parseDouble(usersdata)));
		data.add(new DataTest("DRIVE A",12.9));
		data.add(new DataTest("DRIVE B",14.0));
		data.add(new DataTest("DRIVE C",104.9));
		data.add(new DataTest("DRIVE D",184.2));
		data.add(new DataTest("DRIVE E",114.4));
		data.add(new DataTest("DRIVE F",94.2));
		
		

		
// 
		model.addAttribute("StorageQuota", data);
		
		return"driveanalysis";
	}

}

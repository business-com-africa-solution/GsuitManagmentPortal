package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussinesscom.Africa.GsuitAfrica.AutoComplet.DataTest;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Model.DriveYearly;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.google.api.client.util.DateTime;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.About;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
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
	public String driveAnalysisPage(@PathVariable("userId") String userId, Model model)
			throws GeneralSecurityException, IOException, URISyntaxException {
		System.out.println("UserId" + userId);
		Optional<UserApp> user = userappRepo.findById(userId);
		System.out.println("User------------" + user.get().getEmail());
        
		driveServiceAccount = SercicesAccounts.getDriveService(user.get().getEmail());
		FileList result = driveServiceAccount.files().list()
				.setFields("nextPageToken, files(createdTime,id,name,size) ").execute();
		List<File> file = result.getFiles();

		HashMap<String, List<DriveYearly>> hashMap = new HashMap<String, List<DriveYearly>>();
		List<DriveYearly> list = new ArrayList<DriveYearly>();
		for (int x = 0; x < file.size(); x++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(file.get(x).getCreatedTime().getValue());
			if (!hashMap.containsKey(year)) {
				list.add(new DriveYearly(file.get(x).getName(), 1, file.get(x).getSize()));
				hashMap.put(year, list);
			} else {
				list.add(new DriveYearly(file.get(x).getName(), 1, file.get(x).getSize()));
			}
		}
			
		List<DriveYearly> das = hashMap.get("2019");
		List<DriveYearly> finalData = new ArrayList<DriveYearly>();	
		finalData.add(new DriveYearly("2014", 0, 0l));
		finalData.add(new DriveYearly("2015", 0, 0l));
		finalData.add(new DriveYearly("2016", 0, 0l));
		finalData.add(new DriveYearly("2017", 0, 0l));
		finalData.add(new DriveYearly("2018", 0, 0l));
		
		for (Entry<String, List<DriveYearly>> entry : hashMap.entrySet()) {
		    String key = entry.getKey();
		    List<DriveYearly> value = entry.getValue();
		    
		    Long total = 0L;
			for (int y = 0; y < das.size(); y++) {
				if (das.get(y).getTotalSize() != null) {
					total += das.get(y).getTotalSize();
				}
			} 
		    finalData.add(new DriveYearly(key,value.size(),total));
		}

		
		com.google.api.services.drive.model.About about = driveServiceAccount.about().get().setFields("*").execute();
		String usersDRIVE = String.valueOf(about.getStorageQuota().getUsageInDrive() / 1000000);
		String DriveTrash = String.valueOf(about.getStorageQuota().getUsageInDriveTrash() / 1000000);
		List<DataTest> data = new ArrayList<DataTest>();
		data.add(new DataTest("USAGE (MB)", Double.parseDouble(usersDRIVE)));
		data.add(new DataTest("DRIVE TRASH (MB)", Double.parseDouble(DriveTrash))); 

		model.addAttribute("StorageQuota", data);
		model.addAttribute("yyy", finalData);
		
		return "driveanalysis";
	}
	
	
	
	
	@RequestMapping("DriveAnalysis/{userId}")
	public String EntireOrganization(@PathVariable("userId") String userId, Model model)
			throws GeneralSecurityException, IOException, URISyntaxException {
					Directory serviceDirect=SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");	
					
					com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
				            .setCustomer("my_customer")
				            .setMaxResults(10)
				            .setOrderBy("email")
				            .execute();		
				   List<User> users = result.getUsers(); 
				    
				   for (int i = 0; i < users.size(); i++) {
					   
					   
					
				}
				   
				    
				return "driveanalysis";
		
		
	}
	
	
	



}

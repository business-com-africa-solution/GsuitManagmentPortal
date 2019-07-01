package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussinesscom.Africa.GsuitAfrica.AutoComplet.DataTest;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Domain;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Model.DriveYearly;
import com.bussinesscom.Africa.GsuitAfrica.Model.MyDriveFiles;
import com.bussinesscom.Africa.GsuitAfrica.Repository.DomainRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.Utilities;
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

@Controller
public class DriveAnalysis {

	@Autowired
	UserAppRepositiry userappRepo;

	Drive driveServiceAccount;
	Gmail gmailAnlysisService;

	Directory serviceDirect;
	Gmail serviceGmail;
	List<User> users;

	@Autowired
	DomainRepository domainRepositry;

	@RequestMapping("DriveAnalysis/{userId}")
	public String AccountDeligation(@PathVariable("userId") String userId, Model model,
			final HttpServletRequest request) throws GeneralSecurityException, IOException, URISyntaxException {

		Optional<UserApp> user = userappRepo.findById(userId);
		String loginEmail = user.get().getEmail();
		String[] domain = loginEmail.split("@");
		Domain userDomain = domainRepositry.findByDomainName(domain[1]);
		Company comp = userDomain.getCompany();
		comp.getPackages();
		model.addAttribute("servicesAcess", comp.getPackages().getServices());
		model.addAttribute("package", comp.getPackages().getName());
		model.addAttribute("userName", "" + user.get().getLastName() + " " + user.get().getFirstName());
		model.addAttribute("image", "" + user.get().getImageUrl() + "?ln=california-layout");

		serviceDirect = SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");

		com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
				.setCustomer("my_customer").setMaxResults(10).setOrderBy("email").execute();

		users = result.getUsers();

		model.addAttribute("users", users);

		return "accountdrive";
	}

	@RequestMapping("DriveStatisticalAnalysis/{userId}")
	public String driveAnalysisPage(@PathVariable("userId") String userId, Model model)
			throws GeneralSecurityException, IOException, URISyntaxException {
		System.out.println("UserId" + userId);
		Optional<UserApp> user = userappRepo.findById(userId);
		System.out.println("User------------" + user.get().getEmail());

		driveServiceAccount = SercicesAccounts.getDriveService(user.get().getEmail());
		FileList result = driveServiceAccount.files().list()
				.setFields("nextPageToken, files(createdTime,id,name,size,permissions) ").execute();
		List<File> file = result.getFiles();

		HashMap<String, List<DriveYearly>> hashMap = new HashMap<String, List<DriveYearly>>();
		List<DriveYearly> list = new ArrayList<DriveYearly>();
		for (int x = 0; x < file.size(); x++) {

			System.out.println("File Name : " + file.get(x).getName() + "  " + "Permisions ----------"
					+ file.get(x).getPermissions());
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
		finalData.add(new DriveYearly("2015", 1, 10l));
		finalData.add(new DriveYearly("2016", 1, 10l));
		finalData.add(new DriveYearly("2017", 1, 10l));
		finalData.add(new DriveYearly("2018", 1, 10l));
		finalData.add(new DriveYearly("2019", 1, 10l));

		for (Entry<String, List<DriveYearly>> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			List<DriveYearly> value = entry.getValue();

			Long total = 0L;
			for (int y = 0; y < value.size(); y++) {
				if (value.get(y).getTotalSize() != null) {
					total += value.get(y).getTotalSize();
				}
			}
			finalData.add(new DriveYearly(key, value.size(), total));

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

	@RequestMapping("DrivePermissions/{userId}")
	public String DrivePermissions(@PathVariable("userId") String userId, Model model)
			throws GeneralSecurityException, IOException, URISyntaxException {
		System.out.println("UserId" + userId);
		Optional<UserApp> user = userappRepo.findById(userId);
		System.out.println("User------------" + user.get().getEmail());

		driveServiceAccount = SercicesAccounts.getDriveService(user.get().getEmail());
		FileList result = driveServiceAccount.files().list()
				.setFields("nextPageToken, files(createdTime,id,name,size,permissions) ").execute();
		List<File> file = result.getFiles();

		HashMap<String, List<MyDriveFiles>> myDriveByRoleHashMap = new HashMap<String, List<MyDriveFiles>>();
		List<MyDriveFiles> myDriveFilesList=new ArrayList<MyDriveFiles>();
		List<MyDriveFiles> mySharedDriveFilesList=new ArrayList<MyDriveFiles>();
		
		for (int x = 0; x < file.size(); x++) {
			
				
			System.out.println("=====================================================================");
			
			
			
			for(int s=0;s<file.get(x).getPermissions().size();s++) {
					
				System.out.println("----------------------------------"+Utilities.getEmptyNullStringValue(file.get(x).getPermissions().get(s).getEmailAddress()));
				if (Utilities.getEmptyNullStringValue(file.get(x).getPermissions().get(s).getEmailAddress()).equals(user.get().getEmail())&&file.get(x).getPermissions().get(s).getRole().equals("owner")) {
					
					
					if(file.get(x).getPermissions().size()>1)
					{
						myDriveFilesList.add(new MyDriveFiles(file.get(x).getId(),file.get(x).getName(),Utilities.getEmptyNullLongValue(file.get(x).getCreatedTime()),Utilities.getEmptyNullLongValue(file.get(x).getModifiedTime()),"YES with "+file.get(x).getPermissions().size()));
						
					}
					myDriveFilesList.add(new MyDriveFiles(file.get(x).getId(),file.get(x).getName(),Utilities.getEmptyNullLongValue(file.get(x).getCreatedTime()),Utilities.getEmptyNullLongValue(file.get(x).getModifiedTime()),"NO with 0 "));
					
					System.out.println("FINE NAME                 : "+file.get(x).getName());
					System.out.println("FINE ID                   : "+file.get(x).getPermissions().get(s).getId());
					System.out.println("FINE EMAIL ADDRESS        : "+file.get(x).getPermissions().get(s).getEmailAddress());
					System.out.println("FINE ROLE                 : "+file.get(x).getPermissions().get(s).getRole());
					System.out.println("FINE DOMAIN               : "+file.get(x).getPermissions().get(s).getDomain());
					System.out.println("FINE CREATED DATE         : "+Utilities.getEmptyNullLongValue(file.get(x).getCreatedTime()));	
					System.out.println("FINE MODIFIED DATE TIME   : "+Utilities.getEmptyNullLongValue(file.get(x).getModifiedByMeTime()));
				
				}
				else {
					mySharedDriveFilesList.add(new MyDriveFiles(file.get(x).getId(),file.get(x).getName(),Utilities.getEmptyNullLongValue(file.get(x).getCreatedTime()),Utilities.getEmptyNullLongValue(file.get(x).getModifiedTime()),Utilities.getEmptyNullStringValue(file.get(x).getPermissions().get(s).getEmailAddress()),Utilities.getEmptyNullStringValue(file.get(x).getPermissions().get(s).getRole())));
					
				}
				
				
				
				
				
				
			}
			System.out.println("=====================================================================");
		}

		model.addAttribute("myfiles", myDriveFilesList);
		model.addAttribute("mysharedfiles", mySharedDriveFilesList);
		
		
		
//		System.out.println("OWNER ====="+myDriveByRoleHashMap.get("owner").toString());
//		
//		System.out.println("WRITER ========== "+myDriveByRoleHashMap.get("writer").toString());
//		
		return "drivepermission";
	}

	@RequestMapping("DriveAnalysisAll/{userId}")
	public String EntireOrganization(@PathVariable("userId") String userId, Model model)
			throws GeneralSecurityException, IOException, URISyntaxException {

		Optional<UserApp> user = userappRepo.findById(userId);
		String loginEmail = user.get().getEmail();
		Directory serviceDirect = SercicesAccounts.getDirectoryServices("" + loginEmail);

		com.google.api.services.admin.directory.model.Users result = serviceDirect.users().list()
				.setCustomer("my_customer").setMaxResults(10).setOrderBy("email").execute();
		List<User> users = result.getUsers();

		HashMap<String, List<List<DriveYearly>>> hashMapAll = new HashMap<String, List<List<DriveYearly>>>();

		for (int i = 0; i < users.size(); i++) {

			driveServiceAccount = SercicesAccounts.getDriveService(user.get().getEmail());
			FileList results = driveServiceAccount.files().list()
					.setFields("nextPageToken, files(createdTime,id,name,size) ").execute();
			List<File> file = results.getFiles();

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
			finalData.add(new DriveYearly("2015", 1, 10l));
			finalData.add(new DriveYearly("2016", 1, 10l));
			finalData.add(new DriveYearly("2017", 1, 10l));
			finalData.add(new DriveYearly("2018", 1, 10l));
			finalData.add(new DriveYearly("2019", 1, 10l));

			for (Entry<String, List<DriveYearly>> entry : hashMap.entrySet()) {
				String key = entry.getKey();
				List<DriveYearly> value = entry.getValue();

				Long total = 0L;
				for (int y = 0; y < value.size(); y++) {
					if (value.get(y).getTotalSize() != null) {
						total += value.get(y).getTotalSize();
					}
				}
				finalData.add(new DriveYearly(key, value.size(), total));

			}

		}

		return "driveanalysis";

	}

}

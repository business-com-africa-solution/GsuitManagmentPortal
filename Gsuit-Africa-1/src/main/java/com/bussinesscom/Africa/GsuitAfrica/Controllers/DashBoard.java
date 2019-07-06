package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Domain;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Notification;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Role;
import com.bussinesscom.Africa.GsuitAfrica.Entity.RoleAccess;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Services;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserRole;
import com.bussinesscom.Africa.GsuitAfrica.Model.myContact;
import com.bussinesscom.Africa.GsuitAfrica.Repository.DomainRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.NotificationRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserRoleRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.roleRepository;
//import com.bussinesscom.Africa.GsuitAfrica.Security.AuthenticationManagers;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.admin.directory.DirectoryScopes;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Profile;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.PeopleServiceScopes;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Person;
import com.google.api.services.reseller.Reseller;
import com.google.api.services.reseller.ResellerScopes;
import com.google.api.services.reseller.model.Subscription;
import com.google.api.services.reseller.model.Subscriptions;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.Link;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.docs.Size;
import com.google.gdata.util.ServiceException;

@Controller
public class DashBoard {

	private final String APPLICATION_NAME = "GmailAlexa";
	HttpTransport httpTransport;
	JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	String userId = "me";
	GoogleClientSecrets clientSecrets;
	GoogleAuthorizationCodeFlow flow;
	Credential credential;
	TokenResponse response;
	String token = null;

	String userEmail;
	String userName;

	@Value("${gmail.client.clientId}")
	private String clientId;

	@Value("${gmail.client.clientSecret}")
	private String clientSecret;

	@Value("${gmail.client.redirectUri}")
	private String redirectUri;

	@Value("${gmail.resource.userInfoUri}")
	private String profile;

	Boolean staticLogin = false;

//	UserDetailsService detailsService;
	

//	@Autowired
//	AuthenticationManagers authenticationManagers;
//	
	@Autowired 
	UserAppRepositiry userRepository;
	
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	DomainRepository domainRepositry;
	
	@Autowired
	NotificationRepository notificationRepositry;
	
	


	@RequestMapping(value = "/login/gmail", method = RequestMethod.GET)
	public RedirectView googleConnectionStatus(HttpServletRequest request) throws Exception {	
		
//		System.out.println("Principals==================="+auth.getPrincipal().toString());
			
		return new RedirectView(authorize());
	}

	@RequestMapping(value = "/login/BussnesComAfrica", method = RequestMethod.GET,params = "code")
	public String oauth2Callback( @RequestParam(value = "code") String code,HttpServletRequest request, Model model) {

		
//		@RequestParam(value = "code") String code,
		
		
		
		// String message;
		try {
//			if (staticLogin) {
//				System.out.println("Token Refreshed" + credential.refreshToken());
//
////			} else {
			response = flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
			credential = flow.createAndStoreCredential(response, userId);

//				staticLogin = true;
//			}

//				request.getUserPrincipal().getName();

			
//			Reseller service = new Reseller.Builder(httpTransport, JSON_FACTORY, null).setHttpRequestInitializer(credential)
//					.setApplicationName("Gsuit").build();
//			
//			Subscriptions result = service.subscriptions().list()
//	                
//	                .execute();
//			
//	        List<Subscription> subscriptions = result.getSubscriptions();
//	        if (subscriptions == null || subscriptions.size() == 0) {
//	            System.out.println("No subscriptions found.");
//	        } else {
//	            System.out.println("Subscriptions:");
//	            for (Subscription sub : subscriptions) {
//	                System.out.printf("%s (%s, %s)\n",
//	                        sub.getCustomerId(),
//	                        sub.getSkuId(),
//	                        sub.getPlan().getPlanName());
//	            }
//	        }
	        
			  
			System.out.println("profile Refreshed-------------------------" + profile);
			
			
			 Date date= new Date();
			 long time = date.getTime();
			 Timestamp ts = new Timestamp(time);
			 
			 System.out.println("Current Time Stamp---------: " + ts);
			 
			Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential).setApplicationName(
			          "Oauth2").build();
			 Userinfoplus userinfo = oauth2.userinfo().get().execute();
			 userinfo.toPrettyString();
			
			 
			Gmail myGoogleGmail = new Gmail.Builder(httpTransport, JSON_FACTORY, credential)
					.setApplicationName(APPLICATION_NAME).build();
			String email = myGoogleGmail.users().getProfile("me").execute().getEmailAddress();

			UserApp user=new UserApp();
						
			user.setId(userinfo.getId());
			
			user.setEmail(email);
			user.setFirstName(userinfo.getFamilyName());
			user.setLastName(userinfo.getGivenName());
			user.setUsername(userinfo.getFamilyName()+" "+userinfo.getGivenName());
			user.setImageUrl(userinfo.getPicture());
			user.setPassword(userinfo.getId());
			Company comp=new Company();
			comp.setCompanyId(1);
			user.setCompany(comp);
			user.setUpdatedAt(ts);
			userRepository.saveAndFlush(user);
			
			
			
			
			//			
			
//			UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(email, "");
//			Authentication auth = authenticationManagers.authenticate(email,authReq);
//			SecurityContext securityContext = SecurityContextHolder.getContext();
//			securityContext.setAuthentication(auth);
//		
			
			
			return "redirect:/DashBoard/" + userinfo.getId() + "/";

		} catch (Exception e) {
			e.printStackTrace();
			try {
//				credential.refreshToken();
				String tokens = authorize();
				return "redirect:/login/gmail" + tokens;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "redirect:/login/gmail";
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "redirect:/login/gmail";
			}

			// TODO: handle exception
		}
	}

//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//
//		list.add(new SimpleGrantedAuthority("ADMIN"));
//
//		return list;
//	}

	@RequestMapping("DashBoard/{loginId}")
	public String loginDashBoard(@PathVariable("loginId") String loginId, Model model,final HttpServletRequest request)
			throws IOException, ServiceException, GeneralSecurityException, URISyntaxException {
		
		Optional<UserApp> user=userRepository.findById(loginId);
		List<UserRole> role=userRoleRepository.findByUserApp(user);
		List<Notification> notifications=notificationRepositry.findByUserApp(user);
	
		String loginEmail=user.get().getEmail();
		String[] domain=loginEmail.split("@");
		Domain userDomain= domainRepositry.findByDomainName(domain[1]);
		Company comp=userDomain.getCompany();
		comp.getPackages();
		
		RoleAccess rolesAcesses=role.get(0).getRole().getRoleAcess();
		Services DisplayRoleAccessService=new Services();
		
		
		Boolean billing=rolesAcesses.getBilling().equals(comp.getPackages().getServices().getBilling());
		DisplayRoleAccessService.setBilling(billing);
		
		Boolean signature=  rolesAcesses.getSignature().equals(comp.getPackages().getServices().getSignature());
		DisplayRoleAccessService.setSignature(signature);
		
		Boolean  emailAnalysis=rolesAcesses.getEmailAnalysis().equals(comp.getPackages().getServices().getEmailAnalysis());
		DisplayRoleAccessService.setEmailAnalysis(emailAnalysis);
		
		Boolean  driveAnalysis =rolesAcesses.getDriveAnalysis().equals(comp.getPackages().getServices().getDriveAnalysis());
		DisplayRoleAccessService.setDriveAnalysis(driveAnalysis);
		
		Boolean  calenderApointment=rolesAcesses.getCalenderApointment().equals(comp.getPackages().getServices().getCalenderApointment());
		DisplayRoleAccessService.setCalenderApointment(calenderApointment);
		
		Boolean  hr=rolesAcesses.getHr().equals(comp.getPackages().getServices().getHr());
		DisplayRoleAccessService.setHr(hr);
		
		Boolean  maildelegation=rolesAcesses.getMaildelegation().equals(comp.getPackages().getServices().getMaildelegation());
		DisplayRoleAccessService.setMaildelegation(maildelegation); 
		
		Boolean userManegment=  rolesAcesses.getUserManegment().equals(comp.getPackages().getServices().getUserManegment());
		DisplayRoleAccessService.setUserManegment(userManegment);
		
	
		
		
		System.out.println("Comapany"+comp.getName());
		System.out.println("Domain"+userDomain.getDomainName());
		System.out.println("Package"+comp.getPackages().getName());
		System.out.println("Package"+comp.getPackages().getServices().toString());
		System.out.println("notifications--------"+notifications.size());
			
		model.addAttribute("notifications",notifications );
		model.addAttribute("servicesAcess",DisplayRoleAccessService);
		model.addAttribute("package",comp.getPackages().getName());

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 
		 model.addAttribute("userName", ""+user.get().getLastName()+" "+user.get().getFirstName());		
		 model.addAttribute("image", ""+user.get().getImageUrl()+"?ln=california-layout");
		 model.addAttribute("userId", loginId);
	
		Gmail myGoogleGmailService;
		Drive myGoogleDriveService;
		Calendar myGoogleCalendarService;
		ContactsService contactsService;

		myGoogleGmailService = SercicesAccounts.getGmailService(loginEmail);
		myGoogleDriveService = SercicesAccounts.getDriveService(loginEmail);
		myGoogleCalendarService = SercicesAccounts.getCalenderService(loginEmail);
		contactsService = SercicesAccounts.getconnect(loginEmail);
		
//		Messages And Profile
		Profile myProfile = myGoogleGmailService.users().getProfile(userId).execute();
		List<String> labelIds = new ArrayList<String>();
		labelIds.add("UNREAD");
		labelIds.add("INBOX");
		int unReadMessages = myGoogleGmailService.users().messages().list(userId).setLabelIds(labelIds).execute().size();

		model.addAttribute("unreadInbox", unReadMessages);
		model.addAttribute("userEmail", myProfile.getEmailAddress());
		model.addAttribute("totalInbox", myProfile.getMessagesTotal());

//	Drive List	
		FileList result = myGoogleDriveService.files().list().setFields("nextPageToken, files(id, name)").execute();
		List<File> files = result.getFiles();
		System.out.println("Google Drive Files---" + files.size());
		model.addAttribute("totalDrive", files.size());

//	Contacts List	
		URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full");
		Query myQuery = new Query(feedUrl);
		myQuery.setMaxResults(1000);
		ContactFeed resultFeed = contactsService.query(myQuery, ContactFeed.class);
		Integer contactsSize = resultFeed.getEntries().size();
		List<myContact> myContactList = new ArrayList<>();
		for (int i = 0; i < resultFeed.getEntries().size(); i++) {
			System.out.println(" *********Start*********** " + i);
			for (com.google.gdata.data.extensions.Email email : resultFeed.getEntries().get(i).getEmailAddresses()) {
				String[] emil = email.getAddress().split("@");
				myContactList.add(new myContact(email.getAddress(), emil[0]));
				System.out.print(" " + email.getAddress());

				System.out.print("\n");
			}
		}
		model.addAttribute("myContacts", contactsSize);
		model.addAttribute("frequentcontactslist", myContactList);

//		Calendar Events
		java.util.Calendar rightNow = java.util.Calendar.getInstance();
		rightNow.add(java.util.Calendar.DATE, 368); // add one day
		long nextDayInMillis = rightNow.getTimeInMillis();
		DateTime endDate = new DateTime(nextDayInMillis);
		DateTime now = new DateTime(System.currentTimeMillis());
		com.google.api.services.calendar.model.Events events1 = myGoogleCalendarService.events().list("primary")
				.setMaxResults(10).setTimeMin(now).setTimeMax(endDate).setOrderBy("startTime").setSingleEvents(true)
				.execute();
		List<Event> items = events1.getItems();
		model.addAttribute("calendarEvents", items.size());

		return "dashboard";
	}

	private String authorize() throws Exception {
		AuthorizationCodeRequestUrl authorizationUrl;
//		credential.getRefreshToken();

		if (flow == null) {
			Details web = new Details();
			web.setClientId(clientId);
			web.setClientSecret(clientSecret);
			clientSecrets = new GoogleClientSecrets().setWeb(web);
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, permissions())
					.build();
		}
		authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUri);
		return authorizationUrl.build();
	}

	public static List<String> permissions() {

		List<String> permisions = new ArrayList<>();
		permisions.add(GmailScopes.GMAIL_READONLY); 
		permisions.add("profile");
		permisions.add("https://www.googleapis.com/auth/plus.login");
		permisions.add(ResellerScopes.APPS_ORDER);
		
		return permisions;

	}

	
}

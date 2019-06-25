package com.bussinesscom.Africa.GsuitAfrica.ServiceAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussinesscom.Africa.GsuitAfrica.GsuitAfrica1Application;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.DirectoryScopes;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.Users;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.drive.Drive;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.Gmail.Users.Settings.Delegates.Delete;
import com.google.api.services.gmail.Gmail.Users.Settings.SendAs.Get;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Delegate;
import com.google.api.services.gmail.model.ListDelegatesResponse;
import com.google.api.services.gmail.model.Profile;
import com.google.api.services.gmail.model.SendAs;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.PeopleServiceScopes;
import com.google.gdata.client.contacts.ContactsService;

@RestController
public class SercicesAccounts {

	private static final String APPLICATION_NAME = "Gmail-Alexa";
	private static HttpTransport httpTransport;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	static String SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE = "buscomservice@my-project-95-234306.iam.gserviceaccount.com";
	static String EMAIL_TO_IMPERSONATE = "edwin@dev.businesscom.dk";
	static List<String> SCOPES = new ArrayList<>();
	public static GoogleAuthorizationCodeFlow flow;
	com.google.api.client.googleapis.auth.oauth2.GoogleCredential credential;
	private static ContactsService contactService = null;
	String DOMAIN_NAME = "";
	String accessToken;
	static String userEmail = "";

	public SercicesAccounts() {
	}

	public static String getDataFromPath() {

		String fileName = "config/my-project-95-234306-c14f132641fe.p12";
		ClassLoader classLoader = new GsuitAfrica1Application().getClass().getClassLoader();

		java.io.File file = new java.io.File(classLoader.getResource(fileName).getFile());

		// File is found
		System.out.println("File Found : " + file.getPath());

		return file.getPath();
	}

	public Boolean signatureUpdateForUser(User user, String useremail) {
		try {

			useremail = "edwin@dev.businesscom.dk";
			Gmail gmailService = getGmailService(useremail);
			SendAs send = new SendAs();

//		  	OrgSignature orgSignature=new OrgSignature();
//		  	orgSignature.setNames(user.getName().getFullName());
//		  	orgSignature.setEmailAddress(user.getPrimaryEmail());
//	  orgSignature.setJobPosition("AQ");
//	  orgSignature.setPhoneNumber("087878787");
//	  orgSignature.setCountry("USA");
//	  
//	  send.setSignature( SignatureTemplates.signatureTemplateOne(orgSignature));
//	  gmailService.users().settings().sendAs().patch(user.getPrimaryEmail(),user.getPrimaryEmail(),send).execute();
//	  
			return true;

		} catch (GeneralSecurityException | URISyntaxException | IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Boolean getDirectorateService(String AdminEmail) {
		Directory directs;
		try {
			directs = getDirectoryServices(AdminEmail);

			com.google.api.services.admin.directory.model.Users result = directs.users().list()
					.setCustomer("my_customer").setMaxResults(10).setOrderBy("email").execute();

			List<User> users = result.getUsers();

			if (users == null || users.size() == 0) {
				System.out.println("No users found.");
			} else {

				System.out.println("Users:");
				for (User user : users) {

					signatureUpdateForUser(user, user.getPrimaryEmail());

					System.out.println(user.getLastLoginTime().toString().substring(0,
							(user.getLastLoginTime().toString().length() - 4)));
				}
			}
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Gmail getGmailService(String userEmail)
			throws GeneralSecurityException, IOException, URISyntaxException {

		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath()))
				.setServiceAccountScopes(permisonsAll2()).setServiceAccountUser(userEmail).build();
		credential.getRefreshToken();
		Gmail service = new Gmail.Builder(httpTransport, jsonFactory, null).setHttpRequestInitializer(credential)
				.setApplicationName("Gsuit").build();
		return service;
	}
	
	public static Drive getDriveService(String userEmail)
			throws GeneralSecurityException, IOException, URISyntaxException {

		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath()))
				.setServiceAccountScopes(permisonsAllDrive()).setServiceAccountUser(userEmail).build();
		credential.getRefreshToken();
		Drive service = new Drive.Builder(httpTransport, jsonFactory, null).setHttpRequestInitializer(credential)
				.setApplicationName("Gsuit").build();
		return service;
	}
	
	

	public static PeopleService getPeopleService(String userEmail)
			throws GeneralSecurityException, IOException, URISyntaxException {
		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath()))
				.setServiceAccountScopes(permisonsAll()).setServiceAccountUser(userEmail).build();
		credential.getRefreshToken();

		PeopleService service = new PeopleService.Builder(httpTransport, jsonFactory, null)
				.setHttpRequestInitializer(credential).setApplicationName("Gsuit").build();
		return service;
	}

	public static Directory getDirectoryServices(String userEmail)
			throws GeneralSecurityException, IOException, URISyntaxException {
		System.out.println("Service Account User Email ---------------" + userEmail);

		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath()))
				.setServiceAccountScopes(Collections.singleton(DirectoryScopes.ADMIN_DIRECTORY_USER))
				.setServiceAccountUser(userEmail).build();
		credential.getRefreshToken();
		System.out.println("Token 1-------- Directory " + credential.getAccessToken());
		Directory directoryservice = new Directory.Builder(httpTransport, jsonFactory, null)
				.setHttpRequestInitializer(credential).setApplicationName("Gsuit").build();
		return directoryservice;
	}

	public static GoogleCredential getGoogleCredentialServices(String userEmail)
			throws GeneralSecurityException, IOException, URISyntaxException {
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath()))
				.setServiceAccountScopes(permisonsAll()).setServiceAccountUser(userEmail).build();
		credential.getAccessToken();
		ContactsService contactsService = new ContactsService("MY_PRODUCT_NAME");
		contactsService.setOAuth2Credentials(credential);
//	       
		System.out.println("Token for contact--------" + credential.getAccessToken().toString());
		return credential;
	}

	public static Calendar getCalenderService(String email) throws GeneralSecurityException, IOException {
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JacksonFactory.getDefaultInstance()).setServiceAccountUser(email)
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountScopes(Collections.singleton("https://www.googleapis.com/auth/calendar"))
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath())).build();
		if (!credential.refreshToken()) {
			throw new RuntimeException("Failed OAuth to refresh the token");
		}
		Calendar myService = new Calendar.Builder(httpTransport, jsonFactory, null)
				.setHttpRequestInitializer(credential).setApplicationName("Gsuit").build();

		return myService;
	}

	public static ContactsService getconnect(String email) throws GeneralSecurityException, IOException {
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JacksonFactory.getDefaultInstance()).setServiceAccountUser(email)
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountScopes(Collections.singleton("https://www.google.com/m8/feeds/"))
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath())).build();
		// @formatter:on

		if (!credential.refreshToken()) {
			throw new RuntimeException("Failed OAuth to refresh the token");
		}
		ContactsService myService = new ContactsService(APPLICATION_NAME);
		myService.setOAuth2Credentials(credential);
		System.out.println("Token for contact--------" + credential.getAccessToken().toString());
		return myService;
	}

	public static ContactsService getconnectDelete(String email) throws GeneralSecurityException, IOException {
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		// @formatter:off
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JacksonFactory.getDefaultInstance()).setServiceAccountUser(email)
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL_FROM_DEV_CONSOLE)
				.setServiceAccountScopes(Collections.singleton("https://www.googleapis.com/auth/contacts.readonly"))
				.setServiceAccountPrivateKeyFromP12File(new File(getDataFromPath())).build();
		if (!credential.refreshToken()) {
			throw new RuntimeException("Failed OAuth to refresh the token");
		}
		ContactsService myService = new ContactsService(APPLICATION_NAME);
		myService.setOAuth2Credentials(credential);
		credential.refreshToken();
		System.out.println("Token for contact Delete--------" + credential.getAccessToken().toString());

		return myService;
	}

	public static List<String> permisonsAll2() {

		List<String> permisions = new ArrayList<String>();
		permisions.add(GmailScopes.GMAIL_SETTINGS_SHARING);
		permisions.add(GmailScopes.GMAIL_SETTINGS_BASIC);
		permisions.add(GmailScopes.MAIL_GOOGLE_COM);
		permisions.add(GmailScopes.GMAIL_LABELS);
		return permisions;
	}
	
	public static List<String> permisonsAllDrive() {

		List<String> permisionsdrive = new ArrayList<String>();

		permisionsdrive.add("https://www.googleapis.com/auth/drive");
		
		return permisionsdrive;

	}
	
	
	
	
	

	public static List<String> permisonsAll() {

		List<String> permisions = new ArrayList<>();
//		 permisions.add(GmailScopes.MAIL_GOOGLE_COM);
//		 permisions.add(GmailScopes.GMAIL_COMPOSE);
//		 permisions.add(GmailScopes.GMAIL_INSERT);
		permisions.add(GmailScopes.GMAIL_SETTINGS_SHARING);
//		 permisions.add(GmailScopes.GMAIL_LABELS);
		permisions.add(GmailScopes.GMAIL_SETTINGS_BASIC);
//		 permisions.add(GmailScopes.GMAIL_MODIFY);
//		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_GROUP_MEMBER);
//		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_USERSCHEMA_READONLY);
		permisions.add(DirectoryScopes.ADMIN_DIRECTORY_USER);
		permisions.add("https://www.google.com/m8/feeds/");
		permisions.add("https:/credential/www.googleapis.com/auth/contacts.readonly");
		permisions.add(CalendarScopes.CALENDAR);

////		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_USER_READONLY);
//		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_GROUP);
//		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_USER_ALIAS);
//		 permisions.add(DirectoryScopes.ADMIN_DIRECTORY_USER_ALIAS_READONLY);
//		 permisions.add("https://www.googleapis.com/auth/cloud-platform");
//		 permisions.add("https://www.googleapis.com/auth/iam");
		return permisions;

	}

}

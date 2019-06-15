package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.bussinesscom.Africa.GsuitAfrica.Model.myContact;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
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
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.PeopleServiceScopes;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Person;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.Link;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.docs.Size;
import com.google.gdata.util.ServiceException;

@Controller
public class DashBoard {

	private static final String APPLICATION_NAME = "GmailAlexa";
	private static HttpTransport httpTransport;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	
	public Gmail myGoogleGmailService;
	public Drive myGoogleDriveService;
	public Calendar myGoogleCalendarService;
	public ContactsService contactsService;
	
	
	private static String userId = "me";
	public GoogleClientSecrets clientSecrets;
	public static GoogleAuthorizationCodeFlow flow;
	public static Credential credential;
	public static TokenResponse response;
	public static String token = null;

	public String userEmail;
	public String userName;

	@Value("${gmail.client.clientId}")
	private String clientId;

	@Value("${gmail.client.clientSecret}")
	private String clientSecret;

	@Value("${gmail.client.redirectUri}")
	private String redirectUri;

	@Value("${gmail.resource.userInfoUri}")
	private String profile;

	Boolean staticLogin = false;

	@RequestMapping(value = "/login/gmail", method = RequestMethod.GET)
	public RedirectView googleConnectionStatus(HttpServletRequest request) throws Exception {
		return new RedirectView(authorize());
	}

	@RequestMapping(value = "/login/BussnesComAfrica", method = RequestMethod.GET, params = "code")
	public String oauth2Callback(@RequestParam(value = "code") String code, Model model, HttpSession httpsession) {

		// String message;
		try {
			if (staticLogin) {
				System.out.println("Token Refreshed" + credential.refreshToken());

			} else {
				response = flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
				credential = flow.createAndStoreCredential(response, userId);
				staticLogin = true;
			}

			
			
			
			
				
			return "redirect:/DashBoard";

		} catch (Exception e) {
			e.printStackTrace();
			try {
				credential.refreshToken();
				String tokens = authorize();
				return "redirect:/login/gmailCallback/" + tokens;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping("DashBoard")
	public String loginDashBoard(Model model) throws IOException, ServiceException {

		myGoogleGmailService = new com.google.api.services.gmail.Gmail.Builder(httpTransport, JSON_FACTORY,
				credential).setApplicationName(APPLICATION_NAME).build();
		
		myGoogleDriveService = new Drive.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
		
		 myGoogleCalendarService = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
		
		contactsService = new ContactsService("MY_PRODUCT_NAME");
		contactsService.setOAuth2Credentials(credential);
		
		model.addAttribute("userName", "Edwin Korir");
		model.addAttribute("image", "/jMega avax.faces.resource/images/hands.png?ln=california-layout");

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
		System.out.println("Gmail authorization Url ->" + authorizationUrl);
		return authorizationUrl.build();
	}

	public static List<String> permissions() {

		List<String> permisions = new ArrayList<>();
		/* permisions.add(GmailScopes.MAIL_GOOGLE_COM); */
		permisions.add(GmailScopes.GMAIL_SETTINGS_SHARING);
		permisions.add(GmailScopes.MAIL_GOOGLE_COM);
		permisions.add(PeopleServiceScopes.CONTACTS_READONLY);

		permisions.add(GmailScopes.GMAIL_LABELS);
		permisions.add(GmailScopes.GMAIL_SETTINGS_BASIC);
		permisions.add(CalendarScopes.CALENDAR);
		permisions.add(CalendarScopes.CALENDAR_READONLY);
		permisions.add("https://www.googleapis.com/auth/drive");
		permisions.add("https://www.google.com/m8/feeds/");
		permisions.add("https://www.googleapis.com/auth/contacts.readonly");
		permisions.add("https://www.googleapis.com/auth/cloud-platform");
		permisions.add("https://www.googleapis.com/auth/iam");

		return permisions;

	}

}

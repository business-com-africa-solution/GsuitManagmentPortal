package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussinesscom.Africa.GsuitAfrica.Entity.CalenderAppointmentSlot;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Model.Appointments;
import com.bussinesscom.Africa.GsuitAfrica.Model.Clients;
import com.bussinesscom.Africa.GsuitAfrica.Model.MyEvents;
import com.bussinesscom.Africa.GsuitAfrica.Model.UpdateDirectory;
import com.bussinesscom.Africa.GsuitAfrica.Repository.CalenderAppointmentSlotRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.GmsUrlsRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.Utilities;
import com.google.api.client.util.DateTime;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.Events;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.gmail.Gmail;


@Controller
public class CalenderView {

	
	@Autowired
	UserAppRepositiry userRepository;
	@Autowired
	CalenderAppointmentSlotRepository calenderAppointmentRepository;
	
	@Autowired
	GmsUrlsRepository gmsUrlsRepository;

	

	@RequestMapping("calendersettings/{email}")
	public String CalenderSettings(@PathVariable("email") String email, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {
		UpdateDirectory dataUpdate=new UpdateDirectory();
		model.addAttribute("updateuser",dataUpdate);
		
		Appointments appintments=new Appointments();
		userRepository.findAll();
		
		
		return "calendersettings";
	}
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("calenderppointment/{email}")
	public String postTesting(@PathVariable("email") String email, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {
		List<MyEvents> list = new ArrayList<MyEvents>();
		java.util.Calendar rightNow = java.util.Calendar.getInstance();
		rightNow.add(java.util.Calendar.DATE, 1); // add one day
		long nextDayInMillis = rightNow.getTimeInMillis();
		DateTime endDate = new DateTime("2019-07-30T12:30:00.000+08:00");

		
		Directory dir = SercicesAccounts.getDirectoryServices("" + email);
		User user = dir.users().get("" + email).execute();
		model.addAttribute("user_email", email);
		model.addAttribute("user_phone_number", "07000129");
		model.addAttribute("user_company_location", "50 Muthithi Road The Citadel, 4th Floor");
		model.addAttribute("user_name", "" + user.getName().getFullName());
		model.addAttribute("user_company_name", "" + "BussinesCom Africa");

		System.out.println("Emails ---------------" + user.getPrimaryEmail());
		System.out.println("Id ---------------" + user.getId());
		System.out.println("comming ---------------" + email);

		email = "" + user.getPrimaryEmail();
		Calendar service = SercicesAccounts.getCalenderService("" + email + "");
		DateTime now = new DateTime(System.currentTimeMillis());
		
		com.google.api.services.calendar.model.Events events1 = service.events().list("primary").setMaxResults(100)
				.setTimeMin(now).setTimeMax(endDate).setOrderBy("startTime").setSingleEvents(true).execute();
		
		List<Event> items = events1.getItems();
		if (items.isEmpty()) {
			System.out.println("No upcoming events found.");
		} else {
			System.out.println("Upcoming events");
			for (Event event : items) {
				DateTime start = event.getStart().getDateTime();
				DateTime end = event.getEnd().getDateTime();
				if (start == null) {
					start = event.getStart().getDate();
				} else {
					Long startingDate = event.getStart().getDateTime().getValue();
					Long endingDate = event.getEnd().getDateTime().getValue();
					list.add(new MyEvents("Busy", startingDate, endingDate, "bg-danger"));
					System.out.print("Long Start-----" + event.getStart().getDateTime().getValue() + "\n");
					System.out.print("Long End-----" + event.getEnd().getDateTime().getValue() + "/n");
					System.out.printf("%s (%s)\n", event.getSummary(), start);
				}
			}
		}

		model.addAttribute("element", list);

		model.addAttribute("user_name", email);
		return "newfile.html";
	}

	@RequestMapping(value="calendersetting")
	public String calenderSetting( Model model) {		
		return "calendersetting";
	}
	
	
	
	@RequestMapping("updateCalenderSignature")
	public String createLinksForAll(Model model) throws GeneralSecurityException, IOException, URISyntaxException
	{
		Directory direct = SercicesAccounts.getDirectoryServices("edwin@dev.businesscom.dk");
		
		
		com.google.api.services.admin.directory.model.Users result = direct.users().list()
                .setCustomer("my_customer")
                .setMaxResults(10)
                .setOrderBy("email")
                .execute();
				
        List<User> users = result.getUsers();
        List<Clients> clients=new ArrayList<Clients>();
        
        model.addAttribute("client",new Clients());
        
        if (users == null || users.size() == 0) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
            	Gmail gmail=SercicesAccounts.getGmailService(user.getId());
            	com.google.api.services.gmail.model.SendAs sendAs=gmail.users().settings().sendAs().get(user.getPrimaryEmail(), user.getPrimaryEmail()).execute();
            	
            	
            	gmsUrlsRepository.findById(1).get().getUrl();
            	
            	String link=gmsUrlsRepository.findById(2).get().getUrl()+user.getPrimaryEmail()+"/";
            	UserApp userxx =new UserApp();
            	CalenderAppointmentSlot calenderAppointment=new CalenderAppointmentSlot();
            	
            	userxx.setId(user.getId());
        		
        		System.out.println(" \n"+link+"\n");
        		
        		String calenderAppointmentHtml="        <div style=\"margin-top:5px\">\n" + 
        				"            <hr>\n" + 
        				"            <p ><span style=\"color: blue;margin-left: 20px;font-family: initial\">Click to Request For An Appoint</span></p>\n" + 
        				"            <a href=\""+link+"\"height=\"50px\" width=\"180px\" target=\"_blank\">\n" + 
        				"            <img   src=\"http://www.purebridaliowa.com/wp-content/uploads/2019/02/appointment-request-icon.57110256_std.png\" width=\"250px\" height=\"70px\"></a>\n" + 
        				"        </div>";
        		
        		
        		String sig="<div dir=\"ltr\"><div>                    <div dir=\"ltr\">\n" + 
        				"                <div style=\"display:inline-block;float:left;margin-right:30px\">\n" + 
        				"                        <a href=\"#SignatureSanitizer_SafeHtmlFilter_\"><img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfvoNQxfykTAf2ZsAPVn0HRZALNxDJOh2CDUgesL1R7XZ-iH4O\" width=\"200\" height=\"100\"></a>\n" + 
        				"                <hr>\n" + 
        				"                <div style=\"margin-top:5px\">\n" + 
        				"                           </div><div style=\"margin-top:5px\"></div><div style=\"margin-top:5px\"><b><i><font color=\"#0b5394\">Click to make an appointment</font></i></b></div><div style=\"margin-top:5px\"> "
        											+ "<a href=\""+link+"\"height=\"50px\" width=\"180px\" target=\"_blank\">\n" +                           
        				"						<img src=\"https://oiepull-105d.kxcdn.com/sites/default/files/imce/ISSS/buttons/appointmentbutton-min.png\" width=\"200\" height=\"50\"><br></div><div style=\"margin-top:5px\"><br></div><div style=\"margin-top:5px\"><br></div> \n" + 
        									"   </a>    <div>     \n" + 
        				"                        <div style=\"float:left;background-color:rgb(255,255,255);text-align:left;margin-top:10px;margin-left:2px\"> \n" + 
        				"                            <div>  \n" + 
        				                           
        				"                            </div> \n" + 
        				"                        </div>\n" + 
        				"                </div>                                             </div>\n" + 
        				"            <div style=\"display:inline-block;float:left;margin-right:10px;width:1px;height:130px;background-color:rgb(169,169,169)\">\n" + 
        				"                         \n" + 
        				"            </div>\n" + 
        				"                    <div>\n" + 
        				"                        <div style=\"float:left\">\n" + 
        				"                        <div>"+user.getName().getFullName()+"\"</div>\n" + 
        				"                        <div>07000000</div>\n" + 
        				"                        <div>Developer</div>\n" + 
        				"                        <div><a href=\"#\">"+user.getPrimaryEmail()+"k</a></div>    \n" + 
        				"                        <div>Kenya</div>\n" + 
        				"                                                                          \n" + 
        				"                    </div>\n" + 
        				"            </div>\n" + 
        				"      </div>   \n" + 
        				"</div></div>\n" + 
        				"";
          
        		
            	
            	com.google.api.services.gmail.model.SendAs sendc=new com.google.api.services.gmail.model.SendAs();
//            	sendc.setSignature("<div>"+signature+"<div/>"+""+"<div>"+myCalender+"<div/>");
            	sendc.setSignature(calenderAppointmentHtml);
            			
            	gmail.users().settings().sendAs().update(user.getId(), user.getPrimaryEmail(), sendc).execute();
            	model.addAttribute("userupdate",user.getEmails()	);
  
            	calenderAppointment.setAppointmentActive(false);
            	calenderAppointment.setId(user.getId());
            	calenderAppointment.setCompanyId(1);
            	calenderAppointmentRepository.saveAndFlush(calenderAppointment);
            	
            	
            }
        }
        
	
		return "calendersettings";
		
	}

}

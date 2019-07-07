package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bussinesscom.Africa.GsuitAfrica.Model.Appointment;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.HtmlTemplates;
import com.bussinesscom.Africa.GsuitAfrica.Utils.ServiceResponse;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Setting;



@RestController
public class CalenderRest {

	
	
	@RequestMapping("/createAppointments")
	public ServiceResponse getTesting(@RequestBody String appointment) throws IOException, GeneralSecurityException 
	{
		ServiceResponse response=new ServiceResponse();
		response.setStatus("success");
		response.setData(appointment);
		return response;
	}
	
	
	
	@PostMapping("calenderppointment/{email}/createAppointment/{edwin}")
	public ServiceResponse postTesting(@PathVariable("email") String email,@PathVariable("edwin") String edwin,@RequestBody Appointment appointment) throws IOException, GeneralSecurityException 
	{
		
		 System.out.println("==== in postTesting ====");
		 
		System.out.println("Event created:----------------"+email);
		System.out.println("Event created:----------------"+edwin);
		
		// Retrieve a single user setting
		Calendar service=SercicesAccounts.getCalenderService(email);
		
		Setting setting = service.settings().get("timezone").execute();
		
		String myTimeZone=setting.getValue();
		TimeZone tz = TimeZone.getTimeZone(myTimeZone);
		int GMT=(((tz.getOffset(System.currentTimeMillis()) / 1000) / 60)/60);
		System.out.println("GMT:----------------"+GMT);
		
		System.out.println("Event created:----------------"+appointment.toString());
		
//		String description="<h2 align=\"center\">TITLE</h2>\n" + 
//				"    <div align=\"center\">\n" + 
//				"<p >Create and edit <a href=\"https://validator.w3.org/\" rel=\"nofollow\" target=\"_blank\" title=\"W3C HTML validator\">emailadress</a> without writing a single line of code. The WYSIWYG editor on the left helps non-developers write their own <em>high-quality HTML code</em>.</p>\n" + 
//				"<h3>Know some code? <span class=\"fr-emoticon fr-deletable fr-emoticon-img\" style=\"background: url(https://cdnjs.cloudflare.com/ajax/libs/emojione/2.0.1/assets/svg/1f600.svg);\">&nbsp;</span></h3>\n" + 
//				"<p>The editing works both ways, with live visual feedback. Write some markup code on the right, and it will appear in the left editor.</p>\n" + 
//				"</div>";
//		
		
		String description= HtmlTemplates.templateReturn(appointment.getTitle(),appointment.getFirstName()+" "+appointment.getLastName(), appointment.getPhonenumber(), "NAIROBI", appointment.getEmail(),appointment.getCompany(),appointment.getFromDate(),appointment.getTodate()); 
		
		System.out.println("Description-----------------------   "+description);
		
//		String description="Email Addrres: "+appointment.getEmail()+"\n"+"Firts Name "+appointment.getFirstName()+"\n"+"LastName "+appointment.getLastName()+"\n"+"Phone Number "+appointment.getPhonenumber();	
		
		Event event = new Event()
		    .setSummary(appointment.getTitle())
		    .setDescription(""+description);
			
		DateTime startDateTime = new DateTime((((appointment.getFromDate()))+"+0"+GMT+":00"));
		System.out.println("FromDate:----------------"+(startDateTime));
		
		EventDateTime start = new EventDateTime()
		    .setDateTime(startDateTime)
		    .setTimeZone(myTimeZone);
		event.setStart(start);
	
		DateTime endDateTime = new DateTime((((appointment.getTodate()))+"+0"+GMT+":00"));
		System.out.println("ToDate:----------------"+(endDateTime));
		
		EventDateTime end = new EventDateTime()
		    .setDateTime(endDateTime)
		    .setTimeZone(myTimeZone);
		event.setEnd(end);
		
		EventReminder[] reminderOverrides = new EventReminder[] {
		    new EventReminder().setMethod("email").setMinutes(24 * 60),
		    new EventReminder().setMethod("popup").setMinutes(1),
		};
		Event.Reminders reminders = new Event.Reminders()
		    .setUseDefault(false)
		    .setOverrides(Arrays.asList(reminderOverrides));
		event.setReminders(reminders);
		
		String calendarId = "primary";
		event = service.events().insert(calendarId, event).execute();
		System.out.printf("Event created: %s\n", event.getHtmlLink());
		
		
		ServiceResponse response=new ServiceResponse();
		response.setStatus("success");
		response.setData(appointment);
		return response;
		
	}
	
	
	@RequestMapping(value = "/login/BussnesComAfrica2")
	public String oauth2Callback(@RequestParam(value = "code") String code) {
		System.out.println("user"+code);
		
		return "login.html";
	}

	
	
}

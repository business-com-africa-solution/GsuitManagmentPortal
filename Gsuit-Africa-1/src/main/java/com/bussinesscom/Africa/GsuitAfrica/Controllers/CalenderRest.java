package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussinesscom.Africa.GsuitAfrica.Model.Appointment;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
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
	
	
	@RequestMapping("calenderppointment/{email}/createAppointment/{edwin}")
	public ServiceResponse postTesting(@PathVariable("email") String email,@PathVariable("edwin") String edwin,@RequestBody Appointment appointment) throws IOException, GeneralSecurityException 
	{
		
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
		String description="Email Addrres: "+appointment.getEmail()+"\n"+"Firts Name "+appointment.getFirstName()+"\n"+"LastName "+appointment.getLastName()+"\n"+"Phone Number "+appointment.getPhonenumber();	
		
		Event event = new Event()
		    .setSummary(appointment.getTitle()+"/n"+appointment.getCompany())
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
	
	
	
	
}

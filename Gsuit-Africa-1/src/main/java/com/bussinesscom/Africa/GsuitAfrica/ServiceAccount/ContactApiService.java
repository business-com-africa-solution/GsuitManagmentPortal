package com.bussinesscom.Africa.GsuitAfrica.ServiceAccount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;

public class ContactApiService {
	
	public static void ContactService(String adminEmail,String emailToDelete) 
			throws GeneralSecurityException, IOException, URISyntaxException, ServiceException
	{
		
		Directory directory=SercicesAccounts.getDirectoryServices(adminEmail);
		com.google.api.services.admin.directory.model.Users result = directory.users().list()
                .setCustomer("my_customer")
                .setMaxResults(10)
                .setOrderBy("email")
                .execute();
				
        List<User> users = result.getUsers();
      
        if (users == null || users.size() == 0) {
            System.out.println("No users found.");
        } else {
            System.out.println("Users:");
            for (User user : users) {
            	String userEmail=user.getPrimaryEmail();
            	System.out.println("User Contact Email------"+user.getPrimaryEmail());
            	
            	ContactsService contactsService = SercicesAccounts.getconnect(userEmail);
            	URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full");

                 Query myQuery = new Query(feedUrl);
                  myQuery.setMaxResults(1000);

                  	String deletContactId="absent";
                    ContactFeed resultFeed = contactsService.query(myQuery, ContactFeed.class);		        
                    for (int i = 0; i < resultFeed.getEntries().size(); i++) {
                    	System.out.println(" *********Start*********** "+i); 
                    	for (com.google.gdata.data.extensions.Email email : resultFeed.getEntries().get(i).getEmailAddresses()) {
                    	      System.out.print(" " + email.getAddress());   
                    	      if(emailToDelete.equals(email.getAddress())) 
                	    	  {
                    	    	  System.out.println("Email To Delete--------------------"+emailToDelete);
                    	    	  System.out.println("Contact Id String --------------------"+resultFeed.getEntries().get(i).getId());
	          		              String idString = resultFeed.getEntries().get(i).getId();
	          		              String[] parts = idString.split("/");
	          		              System.out.println(" Values Id-------------  "+parts[8]);
	          		              deletContactId=parts[8];	
                	    	  }
                    	      System.out.print("\n");
                    	    }
                    	
                    	System.out.println(" Group Info = "+resultFeed.getEntries().get(i).getId());
                        System.out.println(" Group Info = "+resultFeed.getEntries().get(i).getGroupMembershipInfos().toString()+" \n");
//                        resultFeed.getEntries().get(i).getGroupMembershipInfos().toString();
                        System.out.println(" *********End*********** "+i+"/n"); 
                    
                    }
                    
                    if(!deletContactId.equals("absent")) {
                    String urlString="https://www.google.com/m8/feeds/contacts/"+userEmail+"/full/"+deletContactId+"";
//                    String urlString="https://www.google.com/m8/feeds/contacts/edwin@dev.businesscom.dk/full/edwinhometest@dev.businesscom.dk";
                    URL contactURL2=new URL(urlString);
                    ContactEntry contact2 = contactsService.getEntry(contactURL2, ContactEntry.class);
                    contact2.delete();
                    deletContactId="absent";
                    }
                    
            }
        }
        
		
		
	
        
//      
	}
}

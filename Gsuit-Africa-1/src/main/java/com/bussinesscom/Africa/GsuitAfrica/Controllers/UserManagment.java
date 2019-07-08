package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.Domain;
import com.bussinesscom.Africa.GsuitAfrica.Entity.RoleAccess;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserRole;
import com.bussinesscom.Africa.GsuitAfrica.Model.UpdateDirectory;
import com.bussinesscom.Africa.GsuitAfrica.Model.myUser;
import com.bussinesscom.Africa.GsuitAfrica.Repository.DomainRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserRoleRepository;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.ContactApiService;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.Utilities;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.UserName;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Delegate;
import com.google.api.services.gmail.model.ListDelegatesResponse;
import com.google.api.services.iam.v1.model.ServiceAccount;
import com.google.gdata.util.ServiceException;

@Controller
public class UserManagment {

	Directory serviceDirect;
	Gmail serviceGmail;
	List<User> users;

	@Autowired
	UserAppRepositiry userrepo;

	@Autowired
	DomainRepository domainRepositry;

	@Autowired
	UserAppRepositiry userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@RequestMapping("Gsuit/login")
	public String getUserLogin(Model model) throws IOException, GeneralSecurityException, URISyntaxException {
		return "login";

	}

	@RequestMapping("usermanagment/{userId}")
	public String getUserManagmentPage(@PathVariable("userId") String userId, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {

		Optional<UserApp> user = userrepo.findById(userId);

		List<UserRole> role = userRoleRepository.findByUserApp(user);
		RoleAccess displayRoleAccessService = role.get(0).getRole().getRoleAcess();
		role.get(0).getRole().getRoleAcess().getCreateUserManagment();
		role.get(0).getRole().getRoleAcess().getUpdateUserManagment();
		role.get(0).getRole().getRoleAcess().getDeleteUserManagment();

		model.addAttribute("update", displayRoleAccessService.getUpdateUserManagment());
		model.addAttribute("delete", displayRoleAccessService.getDeleteUserManagment());
		System.out.println(
				"DENIED---------" + Boolean.valueOf(displayRoleAccessService.getDeleteUserManagment().equals(false)
						&& displayRoleAccessService.getUpdateUserManagment().equals(false)));
		if (Boolean.valueOf(displayRoleAccessService.getDeleteUserManagment().equals(false)
				&& displayRoleAccessService.getUpdateUserManagment().equals(false))) {
			model.addAttribute("acessdenied", false);
		} else {
			model.addAttribute("acessdenied", true);
		}

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
		model.addAttribute("userid", userId);

		return "orgusers";
	}

	@RequestMapping(value = "viewProfile/{userId}", method = RequestMethod.GET)
	public String getUserProfile(@PathVariable("userId") String userId, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {

		String[] ids = userId.split("lg");
		String selectedUserId = ids[0];
		String updateById = ids[1];
		
		Optional<UserApp> meUser = userrepo.findById(updateById);
		String loginEmail = meUser.get().getEmail();
		String[] domain = loginEmail.split("@");
		Domain userDomain = domainRepositry.findByDomainName(domain[1]);
		Company comp = userDomain.getCompany();
		comp.getPackages();
		model.addAttribute("servicesAcess", comp.getPackages().getServices());
		model.addAttribute("package", comp.getPackages().getName());
		model.addAttribute("userName", "" + meUser.get().getLastName() + " " + meUser.get().getFirstName());
		model.addAttribute("image", "" + meUser.get().getImageUrl() + "?ln=california-layout");

		
		model.addAttribute("domain", "dk.businesscom.com");

		for (int a = 0; a < users.size(); a++) {
			if (users.get(a).getId().equals(selectedUserId)) {

				String[] email = users.get(a).getPrimaryEmail().split("@");
				System.out.println("Id------------" + selectedUserId);
				System.out.println("Email------------" + users.get(a).getPrimaryEmail());
				model.addAttribute("familyName", users.get(a).getName().getFamilyName());
				model.addAttribute("givenName", users.get(a).getName().getGivenName());
				model.addAttribute("emailName", email[0]);
				model.addAttribute("id", selectedUserId);

				model.addAttribute("aliaseslist", users.get(a).getAliases());

				UpdateDirectory dataUpdate = new UpdateDirectory();
				dataUpdate.setId(selectedUserId);
				serviceGmail = SercicesAccounts.getGmailService("" + users.get(a).getPrimaryEmail());
				com.google.api.services.gmail.model.SendAs sendAss = serviceGmail.users().settings().sendAs()
						.get(users.get(a).getPrimaryEmail(), users.get(a).getPrimaryEmail()).execute();

				ListDelegatesResponse deligateData = serviceGmail.users().settings().delegates()
						.list(users.get(a).getPrimaryEmail()).execute();
				List<Delegate> deligateList = deligateData.getDelegates();

				model.addAttribute("deligateList", deligateList);
				model.addAttribute("users", users);
				model.addAttribute("signateure", sendAss.getSignature());
				model.addAttribute("updateuser", dataUpdate);

			}
		}

		return "userprofile.html";

	}

	@RequestMapping("deleteUser/{userId}")
	public String getdelete(@PathVariable("userId") String userId, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {

		String[] ids = userId.split("lg");
		String selectedUserId = ids[0];
		String updateById = ids[1];

		model.addAttribute("image", "/jMega avax.faces.resource/images/hands.png?ln=california-layout");
		model.addAttribute("domain", "dk.businesscom.com");

		for (int a = 0; a < users.size(); a++) {
			if (users.get(a).getId().equals(selectedUserId)) {
				System.out.println("Id------------" + selectedUserId);
				System.out.println("Email------------" + users.get(a).getPrimaryEmail());
				serviceDirect.users().delete(users.get(a).getPrimaryEmail()).execute();
			}
		}
		return "redirect:/usermanagment/" + updateById;

	}

	@RequestMapping(value = "createUser/{userId}", method = RequestMethod.GET)
	public String getCreateUser(@PathVariable("userId") String userId, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {

		model.addAttribute("image", "/jMega avax.faces.resource/images/hands.png?ln=california-layout");
		model.addAttribute("domain", "dk.businesscom.com");
		myUser user = new myUser();
		user.setCretedById(userId);
		model.addAttribute("userId", userId);
		model.addAttribute("myUser", user);
		return "userregisteration";

	}

	@RequestMapping(value = "userRegistrations", method = RequestMethod.POST)
	public String getSubmitUser(@ModelAttribute(value = "myUser") myUser myuser, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {

		model.addAttribute("image", "/jMega avax.faces.resource/images/hands.png?ln=california-layout");
		model.addAttribute("domain", "dk.businesscom.com");

//	System.out.println("userId------------" + userId);
//		
//		String[] ids = userId.split("lg");
//		String selectedUserId = ids[0];
//		String updateById = ids[1];

		User users = new User();
		users.setChangePasswordAtNextLogin(true);

		UserName names = new UserName();
		names.setFamilyName("" + myuser.getFamilyName());
		names.setGivenName("" + myuser.getOtherName());
		names.setFullName("" + myuser.getFamilyName() + " " + myuser.getOtherName());
		users.setName(names);

		users.setPrimaryEmail(myuser.getEmailName() + "@dev.businesscom.dk");
		String password = myuser.getDefaultPassword();
		users.setPassword(password);

		System.out.println("Succeess Message ------------- " + users.toString());

		User succeessMessage = serviceDirect.users().insert(users).execute();
		System.out.println("Succeess Message ------------- " + succeessMessage);

		String onsucess = "<div class=\"alert\">\n"
				+ "			 <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
				+ "			 <strong>Sucess!</strong> USER " + succeessMessage.getPrimaryEmail()
				+ " has been created sucessfully\n" + "		   </div>";

		model.addAttribute("onsucessAlert", onsucess);
		myUser newUser = new myUser();
		newUser.setCretedById(myuser.getCretedById());
		model.addAttribute("myUser", newUser);

		return "userregisteration";

	}

	@RequestMapping(value = "/processUpdateForm/{userId}", method = RequestMethod.POST)
	public String upDateUserInformation(@PathVariable("userId") String userId,
			@ModelAttribute(value = "updateuser") UpdateDirectory dataUpdate) throws IOException {

		System.out.println("userId------------" + userId);

		String[] ids = userId.split("lg");
		String selectedUserId = ids[0];
		String updateById = ids[1];

		Optional<UserApp> userApp = userrepo.findById(dataUpdate.getId());

		User userx = new User();
		UserName names = new UserName();
		names.setFamilyName(dataUpdate.getFamilyname());
		names.setGivenName(dataUpdate.getGivenName());
		names.setFullName(dataUpdate.getFullname());
		if (!dataUpdate.getEmailAdress().isEmpty()) {
			userx.setPrimaryEmail(dataUpdate.getEmailAdress() + "@dev.businesscom.dk");
		} else {
			userx.setPrimaryEmail(null);
		}

		userx.setName(names);
		System.out.println("USERS ID------------" + dataUpdate.getId());
		System.out.println("USERS GIVEN NAME------------" + dataUpdate.getGivenName());
		System.out.println("USERS FULL NAME------------" + dataUpdate.getFullname());
		System.out.println("USERS FAMILY NAME------------" + dataUpdate.getFamilyname());
		System.out.println("USERS EMAIL------------" + dataUpdate.getEmailAdress());

		try {
			User user = serviceDirect.users().update(dataUpdate.getId(), userx).execute();
			System.out.println("USERS------------" + user.toString());
			System.out.println("Eliases------------" + user.getAliases());
			if (user != null && Utilities.getNullStringList(user.getAliases()) != 0) {
				ContactApiService.ContactService("edwin@dev.businesscom.dk", user.getAliases().get(0));
			}
			return "redirect:/usermanagment/" + updateById;
		} catch (IOException | GeneralSecurityException | URISyntaxException | ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}

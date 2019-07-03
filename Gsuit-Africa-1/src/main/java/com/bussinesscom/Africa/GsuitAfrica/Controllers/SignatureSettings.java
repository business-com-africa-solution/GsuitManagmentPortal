package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.SignatureTemplate;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Model.Signature;
import com.bussinesscom.Africa.GsuitAfrica.Model.myUser;
import com.bussinesscom.Africa.GsuitAfrica.Repository.SignatureRepository;
import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;
import com.bussinesscom.Africa.GsuitAfrica.ServiceAccount.SercicesAccounts;
import com.bussinesscom.Africa.GsuitAfrica.Utils.Utilities;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.SendAs;

@Controller
public class SignatureSettings {

	@Autowired
	UserAppRepositiry usrRepo;
	
	@Autowired
	SignatureRepository signaterRepo;
	
	@RequestMapping("SignatureSetting/{userId}")
	public String getSignatureLayout(@PathVariable("userId") String userId, Model model) {
		
		
		Company myCompany=(usrRepo.findById(userId)).get().getCompany();
		System.out.println("Company-----------------------"+usrRepo.findById(userId).get().getEmail());
		System.out.println("Company-----------------------"+usrRepo.findById(userId).get().getCompany().getCompanyId());
		List<SignatureTemplate> signatureTemplatesList=signaterRepo.findByCompany(myCompany);
		
		
		model.addAttribute("mysignature",signatureTemplatesList);
		
		model.addAttribute("Signature",new Signature());
		model.addAttribute("userId",userId);
		model.addAttribute("buttontype", "submit");
		
		
		return "signaturesetting";
	}
	


	@RequestMapping(value = "/createdSignature/{userId}", method = RequestMethod.POST)
	public String getSubmitUser(@PathVariable("userId") String userId,@ModelAttribute(value = "Signature") Signature signature, Model model)
			throws IOException, GeneralSecurityException, URISyntaxException {
		
		Optional<UserApp> user= usrRepo.findById(userId);
		SignatureTemplate  templaSignature=new SignatureTemplate();
		templaSignature.setCompany(user.get().getCompany());
		templaSignature.setCreatedBy(user.get().getId());
		templaSignature.setName(signature.getSignatureName());
		templaSignature.setSignatureBody(signature.getSignatureTemplate());
		signaterRepo.saveAndFlush(templaSignature);
		
		System.out.println("Signature-----------------------"+signature.getSignatureTemplate());
				return "redirect:/SignatureSetting/"+userId;
	}
	
	
	@RequestMapping("SetSignature/{userId}")
	public String setSignatureForAll(@PathVariable("userId") String userId, Model model) throws GeneralSecurityException, IOException, URISyntaxException {
		
		String[] ids=userId.split("lg");
		String templateId=ids[0];
		String updateById=ids[1];
		String signatureBody;
		
		Optional<UserApp> users= usrRepo.findById(updateById);
		Company myCompanyUsers=users.get().getCompany();
		List<UserApp> usersList=usrRepo.findByCompany(myCompanyUsers);
		SignatureTemplate signatureTemplateSelected=signaterRepo.findById(Integer.parseInt(templateId)).get();
		signatureBody=signatureTemplateSelected.getSignatureBody();	
		System.out.println("usesList" +usersList.size());
		System.out.println("usesList" +usersList.get(0).toString());
		
		for(int a=0;a<usersList.size();a++) {
			Gmail signatureAccountUpdate=SercicesAccounts.getGmailService(usersList.get(a).getEmail());
			SendAs sendAs=new SendAs();
			String finalSignature=(signatureBody.replaceAll("FirstName", usersList.get(a).getFirstName())).replaceAll("LastName", usersList.get(a).getLastName()).
					replaceAll("PhoneNumber", Utilities.getEmptyNullStringValue(usersList.get(a).getPhoneNumber())).replaceAll("emailAddress", usersList.get(a).getEmail());
			System.out.println(""+finalSignature);
			sendAs.setSignature(finalSignature);
			System.out.println("Email Address "+usersList.get(a).getEmail());
			sendAs.setSendAsEmail(usersList.get(a).getEmail());
			signatureAccountUpdate.users().settings().sendAs().patch(usersList.get(a).getEmail(),usersList.get(a).getEmail(), sendAs).execute();
		}
		signatureTemplateSelected.setIsActive(true);
		signaterRepo.saveAndFlush(signatureTemplateSelected);
		return "redirect:/SignatureSetting/"+users.get().getId();	
	}
	@RequestMapping("DeleteSignature/{userId}")
	public String deleteSignature(@PathVariable("userId") String userId, Model model) throws GeneralSecurityException, IOException, URISyntaxException {
		String[] ids=userId.split("lg");
		String templateId=ids[0];
		String updateById=ids[1];
		signaterRepo.deleteById(Integer.parseInt(templateId));
		return "redirect:/SignatureSetting/"+updateById;
	}
	
	
}

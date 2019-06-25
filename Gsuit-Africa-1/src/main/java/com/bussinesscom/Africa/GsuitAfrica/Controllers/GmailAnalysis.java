package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussinesscom.Africa.GsuitAfrica.AutoComplet.DataTest;

@Controller
public class GmailAnalysis {
	
	

	@RequestMapping("GmailAnalysis/{userId}")
	public String getGmailAnalysis(@PathVariable("userId") String userId, Model model,final HttpServletRequest request) {
		
		List<DataTest> data=new ArrayList<DataTest>();
		data.add(new DataTest("",1));
		
		model.addAttribute("data", data);
		return "data";
		
	}

}

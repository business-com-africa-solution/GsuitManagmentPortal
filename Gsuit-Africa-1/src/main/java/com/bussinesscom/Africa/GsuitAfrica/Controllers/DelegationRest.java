package com.bussinesscom.Africa.GsuitAfrica.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelegationRest {

	
	@RequestMapping("/search")
	public @ResponseBody List searchPost(@RequestParam("term") String query) {

	    List<Object> retVal = getListOfObjectFromDbBasedOnQuery(query);

	    return retVal;
	}

	private List<Object> getListOfObjectFromDbBasedOnQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

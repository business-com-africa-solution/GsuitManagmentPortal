package com.bussinesscom.Africa.GsuitAfrica.AutoComplet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bussinesscom.Africa.GsuitAfrica.Repository.UserAppRepositiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class AutocompleteController {


	@Autowired
	UserAppRepositiry useraprepo;
	
  // http://localhost:8080
  // basic site
  @GetMapping("/DelegateAccounts/{delegateId}")
  public String autocomplete(Model model) {
    model.addAttribute("title", "autocomplete countries example");

    return "deligationformss";
  }


// http://localhost:8080/suggestion?searchstr=car

  /**
   * the rest controller which is requested by the autocomplete input field
   * instead of the countries here could also be made a DB request
   */
  @RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public SuggestionWrapper autocompleteSuggestions(@RequestParam("searchstr") String searchstr) {
    System.out.println("searchstr: " + searchstr);


    ArrayList<Country> suggestions = new ArrayList<>();
    
    useraprepo.findAll();
    System.out.println("Users"+useraprepo.findAll());
    
   String usrs= useraprepo.findAll().toString().replaceAll("[\\[\\]\\(\\)]", "");

    String[] locales=usrs.split(",");
    
//    String[] locales = Locale.getISOCountries();
    
    System.out.println("Countries-----------"+locales.toString());

    for (String countryCode : locales) {
      Locale obj = new Locale("", countryCode);
      // add all countries to the arraylist
      // if on the query string
      if (obj.getDisplayCountry().toLowerCase().contains(searchstr.toLowerCase())) {
        suggestions.add(new Country(obj.getDisplayCountry()));
      }
    }
    
    // truncate the list to the first n, max 20 elements
    int n = suggestions.size() > 20 ? 20 : suggestions.size();
    List<Country> sulb = new ArrayList<>(suggestions.subList(0, n));

    SuggestionWrapper sw = new SuggestionWrapper();
    sw.setSuggestions(sulb);
    return sw;
  }
}

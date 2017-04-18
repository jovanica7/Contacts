package controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import adressBook.Actions;
import adressBook.Contact;

@Controller
public class SearchController {
	
	@RequestMapping(value="/myAddressBook/searchByName", method=RequestMethod.GET)
	public ModelAndView searchFormByName(Model model, @ModelAttribute("firstName") String firstName){
	
	 if(!model.containsAttribute("allContacts")){
		model.addAttribute("allContacts", Actions.findContactByName(firstName));
	}
	
	 return new ModelAndView("index");
	
   }

   @RequestMapping(value="/myAddressBook/searchByName", method=RequestMethod.POST)
   public String searchByName(Contact contact, BindingResult result,  Model model, HttpSession session, RedirectAttributes redirect){
	
	Collection<Contact> results = null;
	String firstName = contact.getFirstName();

	if(StringUtils.isEmpty(contact.getFirstName())){		
		return "redirect:/myAddressBook";
	}
	else{			
		results = Actions.findContactByName(firstName);
	}
	
	session.setAttribute("searchFirstName", firstName);
	
	if(results.size() < 1){
		//result.rejectValue(firstName, "search.contact.notfound", new Object[] {contact.getFirstName()}, "not found");
		redirect.addFlashAttribute("firstName", firstName);	
		return "redirect:/myAddressBook";
	}
	
	redirect.addFlashAttribute("firstName", firstName);
	model.addAttribute("allContacts", results);
	return "index";
	
	
  }
	
	@RequestMapping(value="/myAddressBook/search", method=RequestMethod.GET)
		public ModelAndView searchForm(Model model){
		
		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value="/myAddressBook/search", method=RequestMethod.POST)
	public String search(Contact contact, BindingResult result,  Model model, HttpSession session){
		
		Collection<Contact> results = null;
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();

		if(StringUtils.isEmpty(contact.getFirstName()) && StringUtils.isEmpty(contact.getLastName())){		
			return "redirect:/myAddressBook";
		}
		else{			
			results = Actions.findContactByNameAndSurname(firstName, lastName);
		}
		
		session.setAttribute("searchFirstName", firstName);
		session.setAttribute("searchLastName", lastName);
		
		if(results.size() < 1){
			result.rejectValue(firstName, "search.contact.notfound", new Object[] {contact.getFirstName()}, "not found");
			result.rejectValue(lastName, "search.contact.notfound", new Object[] {contact.getLastName()}, "not found");
			return "redirect:/myAddressBook";
		}
		
		model.addAttribute("allContacts", results);
		return "index";
		
		
	}

}




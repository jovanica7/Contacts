package controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import adressBook.Actions;
import adressBook.Contact;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {
	
	@RequestMapping(value="/myAddressBook", method=RequestMethod.GET)
	public ModelAndView home(Model model){
		
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/myAddressBook/addNew", method=RequestMethod.GET)
	public ModelAndView addNewContact(Model model){
		
		if(!model.containsAttribute("contact")){
			
			model.addAttribute("contact", new Contact());
		}
		
		return new ModelAndView("newContact");
	}
	
	@RequestMapping(value="/myAddressBook/addNew", method=RequestMethod.POST)
	public ModelAndView saveNewContact(@Valid Contact contact, BindingResult result, RedirectAttributes redirectAttributes, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") String last_name, @RequestParam("number") String phone ,@RequestParam("mail") String email){

		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
			redirectAttributes.addFlashAttribute("contact", contact);
			return new ModelAndView("newContact");
		}
		contact = new Contact.ContactBuilder(first_name, last_name)
              .withEmail(email)
              .withPhone(phone)
              .build();
		
		Actions.save(contact);	
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("index");
		
	}
	
	
	@RequestMapping(value="/myAddressBook/update", method=RequestMethod.GET)
	public ModelAndView update(Model model){
		
//		if(!model.containsAttribute("contact")){
//			
//			model.addAttribute("contact", Actions.findContactById(id));
//		}
		
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="/myAddressBook/update", method=RequestMethod.POST)
	public ModelAndView updateContact(@Valid Contact contact, BindingResult result, RedirectAttributes redirectAttributes, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") String last_name, @RequestParam("number") String phone ,@RequestParam("mail") String email){

		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
			redirectAttributes.addFlashAttribute("contact", contact);
			return new ModelAndView("update");
		}
		contact = new Contact.ContactBuilder(first_name, last_name)
              .withEmail(email)
              .withPhone(phone)
              .build();
		
		Actions.update(contact);	
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("index");
		
	}
	
	
//	@RequestMapping(value="/myAdressBook/updateContact", method=RequestMethod.GET)
//	public ModelAndView updateContact(Model model){
//		
//		//Contact contact = Actions.findContactById(id);
//		//Actions.update(contact);
//		return new ModelAndView("updateContact");
//	}
//	
//	@RequestMapping(value=" /myAdressBook/{id}", method=RequestMethod.DELETE)
//	public void deleteContact(@PathVariable int id){
//		
//		Contact contact = Actions.findContactById(id);
//		Actions.delete(contact);
//	}
}

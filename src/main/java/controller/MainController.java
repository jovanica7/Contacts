package controller;


import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import adressBook.Actions;
import adressBook.Contact;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController{
	
	@RequestMapping(value="/myAddressBook", method=RequestMethod.GET)
	public ModelAndView home(Model model){
		
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/myAddressBook/addNew", method=RequestMethod.GET)
	public ModelAndView formNewContact(Model model){
		
		if(!model.containsAttribute("contact")){	
			model.addAttribute("contact", new Contact());
		}
		
		return new ModelAndView("newContact");
	}
	
	@RequestMapping(value="/myAddressBook/addNew", method=RequestMethod.POST)
	public RedirectView addNewContact(@Valid Contact contact, BindingResult result, RedirectAttributes redirect, Model model){

		if(result.hasErrors()){
			redirect.addFlashAttribute("contact", contact);	
			return new RedirectView("redirect:/myAddressBook/addNew");
		}
		
		Actions.save(contact);	
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new RedirectView("/myAddressBook");
		
	}
	
	@RequestMapping(value = "/myAddressBook/delete", method = RequestMethod.POST)
	public ModelAndView deleteContact(@RequestParam("id") int id, Model model) {
		
			Contact contact = Actions.findContactById(id);
			Actions.delete(contact);		
			model.addAttribute("allContacts", Actions.fetchAllContacts());
			return new ModelAndView("redirect:/myAddressBook");
		
	}
	
	@RequestMapping(value="/myAddressBook/update/{id}", method=RequestMethod.GET)
	public ModelAndView formUpdateContact(@PathVariable int id, Model model, RedirectAttributes redirect){
		
		if(!model.containsAttribute("contact")){
			model.addAttribute("contact", Actions.findContactById(id));
		}
		
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="/myAddressBook/update/{id}", method=RequestMethod.POST)
	public RedirectView updateContact(@Valid Contact contact, BindingResult result, RedirectAttributes redirect, Model model){
		
		if(result.hasErrors() && contact!= null){
			redirect.addFlashAttribute("contact", contact);
			return new RedirectView("redirect:/myAddressBook/update/" + contact.getId());
		}	
		
		Actions.update(contact);	
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new RedirectView("/myAddressBook");
		
	}
	
}
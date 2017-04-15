package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import adressBook.Actions;
import adressBook.Contact;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {
	
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
	public ModelAndView addNewContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, RedirectAttributes redirect, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") 
	String last_name, @RequestParam("date") String dateOfBirth, @RequestParam("address") String address, @RequestParam("number") String phone, @RequestParam("mail") String email,  @RequestParam("pol") String sex){

//		if(result.hasErrors() && contact!= null){
//			model.addAttribute("contact", Actions.findContactById(id));
//			redirect.addFlashAttribute("contact", contact);
//			return new ModelAndView("redirect:/myAddressBook/addNew");
//		}
		
		contact = new Contact.ContactBuilder(first_name, last_name)
				.withDate(dateOfBirth)
				.withAddress(address)
				.withEmail(email)
				.withPhone(phone)
				.withSex(sex) 
				.build();
		
		Actions.save(contact);	
		model.addAttribute("contact", contact);
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("redirect:/myAddressBook");
		
	}
	
	
//	@RequestMapping(value="/myAddressBook/update/{id}", method=RequestMethod.POST)
//	public ModelAndView update(Model model, @RequestParam("id") int id){
//		
////		if(!model.containsAttribute("contact")){
////			
////			model.addAttribute("contact", Actions.findContactById(id));
////		}
//		
//		//String id = request.getParameter("id");
//		//int ident = Integer.parseInt(id);
//		System.out.println("Ovo je id" + id);
//		Contact contact = Actions.findContactById(id);
//		model.addAttribute("contact", contact);
//		
//		return new ModelAndView("update");
//	}
	
	@RequestMapping(value = "/myAddressBook/delete", method = RequestMethod.POST)
	public ModelAndView deleteContact(@RequestParam("id") int id, Model model) {
		
			Contact contact = Actions.findContactById(id);
			Actions.delete(contact);		
			model.addAttribute("allContacts", Actions.fetchAllContacts());
			return new ModelAndView("redirect:/myAddressBook");
		
	}
	
	@RequestMapping(value="/myAddressBook/update", method=RequestMethod.GET)
	public ModelAndView formUpdateContact(@ModelAttribute(value="contact") Contact contact, Model model){
		
		if(!model.containsAttribute("contact")){
			int id = contact.getId();
			model.addAttribute("contact", Actions.findContactById(id));
		}
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="/myAddressBook/update", method=RequestMethod.POST)
	public ModelAndView updateContact(Contact contact, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") 
	String last_name, @RequestParam("date") String dateOfBirth, @RequestParam("address") String address, @RequestParam("number") String phone, @RequestParam("mail") String email,  @RequestParam("pol") String sex){

//		if(result.hasErrors() && contact!= null){
//			redirect.addFlashAttribute("contact", contact);
//			return new ModelAndView("redirect:/myAddressBook/addNew");
//		}	
		contact = new Contact.ContactBuilder(first_name, last_name)
				.withDate(dateOfBirth)
				.withAddress(address)
				.withEmail(email)
				.withPhone(phone)
				.withSex(sex) 
				.build();
		
		Actions.update(contact);	
		model.addAttribute("contact", contact);
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("redirect:/myAddressBook");
		
	}

}

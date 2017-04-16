package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.fabric.xmlrpc.base.Data;

import adressBook.Actions;
import adressBook.Contact;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ModelAndView addNewContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, RedirectAttributes redirect, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") 
	String last_name, @RequestParam("date") String dateOfBirth, @RequestParam("address") String address, @RequestParam("number") String phone, @RequestParam("mail") String email,  @RequestParam("pol") String sex){

		if(result.hasErrors() && contact!= null){
			redirect.addFlashAttribute("contact", contact);
			return new ModelAndView("redirect:/myAddressBook/addNew");
		}
		
		contact = new Contact.ContactBuilder(first_name, last_name)
				.withDate(dateOfBirth)
				.withAddress(address)
				.withEmail(email)
				.withPhone(phone)
				.withSex(sex) 
				.build();
		
		Actions.save(contact);	
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("redirect:/myAddressBook");
		
	}
	
	@RequestMapping(value = "/myAddressBook/delete", method = RequestMethod.POST)
	public ModelAndView deleteContact(@RequestParam("id") int id, Model model) {
		
			Contact contact = Actions.findContactById(id);
			Actions.delete(contact);		
			model.addAttribute("allContacts", Actions.fetchAllContacts());
			return new ModelAndView("redirect:/myAddressBook");
		
	}
	
//	@RequestMapping(value = "/myAddressBook/updateId", method = RequestMethod.POST)
//	public ModelAndView updateId(@RequestParam("contact_id") int contact_id, @ModelAttribute Contact contact, Model model, RedirectAttributes redirect) {
//			
//			//redirect.addFlashAttribute("id", id);
//			return new ModelAndView("redirect:/myAddressBook/update/" + String.valueOf(contact_id));
//		
//	}
	
	@RequestMapping(value="/myAddressBook/update/{id}", method=RequestMethod.GET)
	public ModelAndView formUpdateContact(Contact contact, @PathVariable int id, Model model, RedirectAttributes redirect){
		
		//@ModelAttribute("Id") int Id,
		if(!model.containsAttribute("contact")){
			model.addAttribute("contact", Actions.findContactById(id));
		}
		
		//redirect.addFlashAttribute("id", id);
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="/myAddressBook/update/{id}", method=RequestMethod.POST)
	public ModelAndView updateContact(@Valid Contact contact, BindingResult result, RedirectAttributes redirect, @PathVariable int id, Model model, @RequestParam("fname") String first_name, @RequestParam("lname") 
	String last_name, @RequestParam("date") String dateOfBirth, @RequestParam("address") String address, @RequestParam("number") String phone, @RequestParam("mail") String email,  @RequestParam("pol") String sex){
		
	
		if(result.hasErrors() && contact!= null){
			redirect.addFlashAttribute("contact", contact);
			return new ModelAndView("redirect:/myAddressBook/update/" + String.valueOf(id));
		}	
		
		System.out.println("Ono sto mi treba je " + id);
		contact = Actions.findContactById(id);
		contact.setFirstName(first_name);
		contact.setLastName(last_name);
		contact.setDateOfBirth(dateOfBirth);
		contact.setAddress(address);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setSex(sex);
		
		Actions.update(contact);	
		model.addAttribute("contact", contact);
		model.addAttribute("allContacts", Actions.fetchAllContacts());
		return new ModelAndView("redirect:/myAddressBook");
		
	}

}

package controller;

import adressBook.Actions;
import adressBook.Contact;
import adressBook.Contact.ContactBuilder;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {
	
//	@RequestMapping("/myAdressBook")
//	public void home(HttpServletRequest request, HttpServletResponse response,
//	        ServletContext servletContext, TemplateEngine templateEngine) throws IOException{
//		
//		List<Contact> allContacts = Actions.fetchAllContacts();
////		model = new ModelAndView("index");
////		model.addObject("list", allContacts);
//		
//		WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
//		ctx.setVariable("contacts", allContacts);
//
//		templateEngine.process("contacts/list", ctx, response.getWriter());
//		//return "index";
//	}
	
	@RequestMapping(value="/myAdressBook", method=RequestMethod.GET)
	public ModelAndView home(){
		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/myAdressBook/addNew", method=RequestMethod.GET)
	public ModelAndView addNewContact(){
		
		return new ModelAndView("newContact");
	}
	
	@RequestMapping(value="/myAdressBook", method=RequestMethod.POST)
	public ModelAndView saveNewContact(@RequestParam("fname") String first_name, @RequestParam("lname") String last_name, @RequestParam("number") String phone ,@RequestParam("mail") String email){
		
		Contact c = new Contact.ContactBuilder(first_name, last_name)
	              .withEmail(email)
	              .withPhone(phone)
	              .build();
		Actions.save(c);
		ModelAndView model = new ModelAndView("index");
		model.addObject(c);
		return model;
		
	}
	
	@RequestMapping(value="/myAdressBook/updateContact", method=RequestMethod.GET)
	public ModelAndView updateContact(Model model){
		
		//Contact contact = Actions.findContactById(id);
		//Actions.update(contact);
		return new ModelAndView("updateContact");
	}
	
	@RequestMapping(value=" /myAdressBook/{id}", method=RequestMethod.DELETE)
	public void deleteContact(@PathVariable int id){
		
		Contact contact = Actions.findContactById(id);
		Actions.delete(contact);
	}
}

package adressBook;

import controller.MainController;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
public class Application {

  public static void main(String[] args) {
	  
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
	  SpringApplication.run(Application.class, args);
	  
//      Contact contact = new Contact.ContactBuilder("Aleksandar","Dakic")
//              .withEmail("acadakic@gmail.com")
//              .withPhone("+381643298175")
//              .build();
//      int id = save(contact);
//
//      // Display a list of contacts before the update
//      System.out.printf("%n%nBefore update%n%n");  
//      for(Contact c: fetchAllContacts()){
//    	  System.out.println(c);
//      }
//      
//      // Get the persisted contact
//      Contact con = findContactById(id);
//
//      // Update the contact
//      con.setFirstName("Aleksa");
//
//      // Persist the changes
//      System.out.printf("%nUpdating...%n");
//      update(con);
//      System.out.printf("%nUpdate complete!%n");
//
//      // Display a list of contacts after the update
//      System.out.printf("%nAfter update%n");
//      for(Contact c: fetchAllContacts()){
//    	  System.out.println(c);
//      }
//
//      // Get the contact with id of 1
//      con = findContactById(1);
//
//      // Delete the contact
//      System.out.printf("%nDeleting...%n");
//      delete(con);
//      System.out.printf("%nDeleted!%n");
//      System.out.printf("%nAfter delete%n");
//      for(Contact c: fetchAllContacts()){
//    	  System.out.println(c);
//      }
  }


  
}
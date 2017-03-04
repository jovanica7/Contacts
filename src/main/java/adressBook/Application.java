package adressBook;


import adressBook.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    //Create a StandardServiceRegistry
    final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    return new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public static void main(String[] args) {
	  
	  SpringApplication.run(Application.class, args);
	  
      Contact contact = new Contact.ContactBuilder("Aleksandar","Dakic")
              .withEmail("acadakic@gmail.com")
              .withPhone("0643298175")
              .build();
      int id = save(contact);

      // Display a list of contacts before the update
      System.out.printf("%n%nBefore update%n%n");  
      for(Contact c: fetchAllContacts()){
    	  System.out.println(c);
      }
      
      // Get the persisted contact
      Contact con = findContactById(id);

      // Update the contact
      con.setFirstName("Aleksa");

      // Persist the changes
      System.out.printf("%nUpdating...%n");
      update(con);
      System.out.printf("%nUpdate complete!%n");

      // Display a list of contacts after the update
      System.out.printf("%nAfter update%n");
      for(Contact c: fetchAllContacts()){
    	  System.out.println(c);
      }

      // Get the contact with id of 1
      con = findContactById(1);

      // Delete the contact
      System.out.printf("%nDeleting...%n");
      delete(con);
      System.out.printf("%nDeleted!%n");
      System.out.printf("%nAfter delete%n");
      for(Contact c: fetchAllContacts()){
    	  System.out.println(c);
      }
  }

  private static Contact findContactById(int id) {
      // Open a session
      Session session = sessionFactory.openSession();

      // Retrieve the persistent object (or null if not found)
      Contact contact = session.get(Contact.class,id);

      // Close the session
      session.close();

      // Return the object
      return contact;
  }

  private static void delete(Contact contact) {
      // Open a session
      Session session = sessionFactory.openSession();

      // Begin a transaction
      session.beginTransaction();

      // Use the session to update the contact
      session.delete(contact);

      // Commit the transaction
      session.getTransaction().commit();

      // Close the session
      session.close();
  }

  private static void update(Contact contact) {
      // Open a session
      Session session = sessionFactory.openSession();

      // Begin a transaction
      session.beginTransaction();

      // Use the session to update the contact
      session.update(contact);

      // Commit the transaction
      session.getTransaction().commit();

      // Close the session
      session.close();
  }

  // @SuppressWarnings("unchecked")
  private static List<Contact> fetchAllContacts() {
      // Open a session
      Session session = sessionFactory.openSession();

      // Create Criteria
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Contact> criteria = builder.createQuery(Contact.class);
      criteria.from(Contact.class);
      
      // Get a list of Contact objects according to the Criteria object
      List<Contact> contacts = session.createQuery(criteria).getResultList();

      // Close the session
      session.close();

      return contacts;
  }

  private static int save(Contact contact) {
      // Open a session
      Session session = sessionFactory.openSession();

      // Begin a transaction
      session.beginTransaction();

      // Use the session to save the contact
      int id = Integer.parseInt(session.save(contact).toString());

      // Commit the transaction
      session.getTransaction().commit();

      // Close the session
      session.close();

      return id;
  }
}
package adressBook;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import adressBook.Contact;

@Component
public class Actions {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	  private static SessionFactory buildSessionFactory() {
	    //Create a StandardServiceRegistry
	    final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	  }
	  
	  public static Contact findContactById(@PathParam("id") int id) {
		  
	      // Open a session
	      Session session = sessionFactory.openSession();

	      // Retrieve the persistent object (or null if not found)
	      Contact contact = session.get(Contact.class,id);

	      // Close the session
	      session.close();

	      // Return the object
	      return contact;
	  }
	  
	  public static List<Contact> findContactByName(@PathParam("firstName") String firstName) {
		  
	      // Open a session
	      Session session = sessionFactory.openSession();
	      
	      // Create Criteria
	      CriteriaBuilder builder = session.getCriteriaBuilder();
	      CriteriaQuery<Contact> criteria =  builder.createQuery(Contact.class);
	      
	     // Select contact with passed first name 
	      Root<Contact> contact = criteria.from(Contact.class);
	      criteria.select(contact);
	      criteria.where(builder.equal(contact.get("firstName"), firstName));
	      
	      // Get result list
	      List<Contact> contacts = session.createQuery(criteria).getResultList();
	      
	      // Close the session
	      session.close();

	      // Return the object
	      return contacts;
	  }
 
	public static List<Contact> findContactByNameAndSurname(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
	  
	     // Open a session
	     Session session = sessionFactory.openSession();
	     
	     // Create Criteria
	      CriteriaBuilder builder = session.getCriteriaBuilder();
	      CriteriaQuery<Contact> criteria = builder.createQuery(Contact.class);
	      
	     // Select contact with passed first name and last name
	      Root<Contact> contact = criteria.from(Contact.class);
	      criteria.select(contact);
	      criteria.where(builder.equal(contact.get("firstName"), firstName));
	      criteria.where(builder.equal(contact.get("lastName"), lastName));
	      
	      // Get result list
	      List<Contact> contacts = session.createQuery(criteria).getResultList();
	      
	     // Close the session
	     session.close();
	
	     // Return the object
	     return contacts;
	  }
	  
	  public static void delete(Contact contact) {
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

	  public static void update(Contact contact) {
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
	  
	  public static int save(Contact contact) {
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
	  
	  public static List<Contact> fetchAllContacts() {
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
	  
	  


}

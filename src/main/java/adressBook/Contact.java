package adressBook;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import java.lang.String;

@Component
@Entity
@Table(name = "contact")
public class Contact {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @Size(min = 2, max = 20)
    private String firstName;

    @Column(name = "lastName")
    @Size(min = 2, max = 20)
    private String lastName;
    
    @Column(name = "address")
    @Size(min = 2, max = 30)
    private String address;

    @Column(name = "email")
    @Size(min = 2, max = 30)
    private String email;

    @Column(name = "phone")
    @Size(min = 2, max = 30)
    private String phone;
    
    @Column(name = "dateOfBirth")
    @Size(min = 2, max = 30)
    private String dateOfBirth;
    
    @Column(name = "sex")
    @Size(min = 4, max = 6)
    private String sex;
    
    // Default constructor for JPA
    public Contact(){}

    public Contact(ContactBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.email = builder.email;
        this.phone = builder.phone;
        this.dateOfBirth = builder.dateOfBirth;
        this.sex = builder.sex;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getDateOfBirth() {
    	return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
    	this.dateOfBirth = dateOfBirth;
    }
    
    public String getSex() {
    	return sex;
    }
    
    public void setSex(String sex) {
    	this.sex = sex;
    }
    
    public static class ContactBuilder {
        private String firstName;
        private String lastName;
        private String address;
        private String email;
        private String phone;
        private String dateOfBirth;
        private String sex;
    

        public ContactBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        public ContactBuilder withAddress(String address) {
        	this.address = address;
        	return this;
        }
        
        public ContactBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public ContactBuilder withDate(String dateOfBirth) {
        	this.dateOfBirth = dateOfBirth;
        	return this;
        }
        
        public ContactBuilder withSex(String sex) {
        	this.sex = sex;
        	return this;
        }
        
        public Contact build() {
            return new Contact(this);
        }
    }
}

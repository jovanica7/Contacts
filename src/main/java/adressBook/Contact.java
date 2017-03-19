package adressBook;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Size(min = 5, max = 30)
    private String email;

    @Column(name = "phone")
    @NotNull
    @Size(min = 5, max = 30)
    private String phone;

    // Default constructor for JPA
    public Contact(){}

    public Contact(ContactBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
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

    public static class ContactBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        public ContactBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public ContactBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder withPhone(String string) {
            this.phone = string;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}

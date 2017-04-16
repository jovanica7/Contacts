package adressBook;

import controller.MainController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude=org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class)
@ComponentScan(basePackageClasses = MainController.class)
public class Application {

  public static void main(String[] args) {

	  SpringApplication.run(Application.class, args);
	  

  }


  
}
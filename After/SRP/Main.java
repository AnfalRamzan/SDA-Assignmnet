package LMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        // Start Spring Boot application
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // Get Library bean from Spring container
        Library library = context.getBean(Library.class);

        // Testing
        library.setName("My Digital Library");

        System.out.println("Library started successfully using Spring Boot");
        System.out.println("Library Name: " + library.getLibraryName());
    }
}

import org.springframework.stereotype.Component;

@Component
public class Librarian extends User {

    public Librarian() {
        super("Sara", "L1");
    }

    public void addBook(String title) {
        System.out.println("Book added: " + title);
    }
}
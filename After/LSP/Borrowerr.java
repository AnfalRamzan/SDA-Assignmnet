import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Borrower extends User {

    private Issuable book;

    @Autowired
    public Borrower(Issuable book) {
        super("Ali", "B1");
        this.book = book;
    }

    public void borrowBook() {
        book.issue();  // injected dependency
    }
}
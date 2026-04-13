import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Borroweerr extends Person {
    private List<Loan> borrowedBooks;
    private List<HoldRequest> onHoldBooks;

    public Borroweerr(int id, String name, String address, int phoneNum) {
        super(id, name, address, phoneNum);
        borrowedBooks = new ArrayList<>();
        onHoldBooks = new ArrayList<>();
    }

    public void addBorrowedBook(Loan loan) { borrowedBooks.add(loan); }
    public void addHoldRequest(HoldRequest hr) { onHoldBooks.add(hr); }
    public List<Loan> getBorrowedBooks() { return borrowedBooks; }
    public List<HoldRequest> getOnHoldBooks() { return onHoldBooks; }
}

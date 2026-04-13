import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Libraaryy {
    private final IBookRepository bookRepository;
    private final ILoanRepository loanRepository;
    private final IPersonRepository personRepository;

    @Autowired
    public Libraaryy(IBookRepository bookRepo, ILoanRepository loanRepo, IPersonRepository personRepo) {
        this.bookRepository = bookRepo;
        this.loanRepository = loanRepo;
        this.personRepository = personRepo;
    }

    public void addBook(Boookk b) { bookRepository.addBook(b); }
    public void addLoan(Loan l) { loanRepository.addLoan(l); }
    public void addPerson(Person p) { personRepository.addPerson(p); }
}

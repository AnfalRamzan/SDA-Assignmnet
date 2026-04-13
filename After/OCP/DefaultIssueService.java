package LMS;

import org.springframework.stereotype.Service;

@Service("defaultIssueService")
public class DefaultIssueService implements IssueService {

    @Override
    public void issue(Book book, Borrower borrower, Staff staff) {
        System.out.println("Default Issue: " + book.getTitle());
        book.setIssued(true);
    }
}

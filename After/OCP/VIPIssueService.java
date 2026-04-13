package LMS;

import org.springframework.stereotype.Service;

@Service("vipIssueService")
public class VIPIssueService implements IssueService {

    @Override
    public void issue(Book book, Borrower borrower, Staff staff) {
        System.out.println("VIP Priority Issue: " + book.getTitle());
        book.setIssued(true);
    }
}

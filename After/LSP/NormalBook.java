import org.springframework.stereotype.Component;

@Component
public class NormalBook extends Book implements Issuable {

    public NormalBook() {
        super("Default Book", "Unknown");
    }

    @Override
    public void issue() {
        System.out.println("Issuing book: " + title);
    }
}
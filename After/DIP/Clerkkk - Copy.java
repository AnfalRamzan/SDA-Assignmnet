import org.springframework.stereotype.Component;

@Component
public class Clerkkk extends StafFf {
    private int deskNo;

    public Clerkkk(int id, String n, String a, int ph, double s, int dk) {
        super(id, n, a, ph, s);
        this.deskNo = dk;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Desk Number: " + deskNo);
    }
}

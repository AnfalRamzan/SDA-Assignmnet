import org.springframework.stereotype.Component;

@Component
public class Libraariann extends StafFf {
    private int officeNo;

    public Libraariann(int id, String n, String a, int p, double s, int of) {
        super(id, n, a, p, s);
        this.officeNo = of;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Office Number: " + officeNo);
    }
}

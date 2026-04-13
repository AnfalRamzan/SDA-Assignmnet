import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Boookk {
    private final IHoldRequestOperations holdRequestsOperations;

    @Autowired
    public Boookk(IHoldRequestOperations holdRequestsOperations) {
        this.holdRequestsOperations = holdRequestsOperations;
    }

    public void placeBookOnHold(Borroweerr bor) {
        HoldRequest hr = new HoldRequest(bor, this, new Date());
        holdRequestsOperations.addHoldRequest(hr);
        bor.addHoldRequest(hr);
    }
}

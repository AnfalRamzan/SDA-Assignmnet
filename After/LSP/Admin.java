import org.springframework.stereotype.Component;

@Component
public class Admin extends User {

    public Admin() {
        super("Admin", "A1");
    }

    public void addUser(User user) {
        System.out.println("User added: " + user.name);
    }
}
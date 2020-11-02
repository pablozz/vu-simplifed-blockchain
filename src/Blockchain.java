import java.util.ArrayList;

public class Blockchain {

    private ArrayList<User> users;
    private final int usersAmount;

    Blockchain(int usersAmount) {
        this.usersAmount = usersAmount;
        generateUsers();
    }

    private void generateUsers() {
        for (int i = 0; i < usersAmount; i++) {
            String name = "User" + 1;
            String publicKey = "";
            double balance = 0;
            User newUser = new User(name, publicKey, balance);
            this.users.add(newUser);
        }
    }
}

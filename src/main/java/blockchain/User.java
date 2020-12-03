package blockchain;

public class User {

    private final String name;
    private final String publicKey;
    private double balance;

    User(String name, String publicKey, double balance) {
        this.name = name;
        this.publicKey = publicKey;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        this.balance += amount;
    }

    public void reduceBalance(double amount) {
        this.balance -= amount;
    }
}

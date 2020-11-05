package blockchain;

public class User {

    private String name;
    private final String publicKey;
    private double balance;

    User(String name, String publicKey, double balance) {
        this.name = name;
        this.publicKey = publicKey;
        this.balance = balance;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getPublicKey() {
        return publicKey;
    }

    double getBalance() {
        return balance;
    }

    void increaseBalance(double amount) {
        this.balance += amount;
    }

    void reduceBalance(double amount) {
        this.balance -= amount;
    }
}

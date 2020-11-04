import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final int USERS_AMOUNT = 1000;
        final int TRANSACTIONS_AMOUNT = 10000;

        Blockchain blockchain = new Blockchain(USERS_AMOUNT, TRANSACTIONS_AMOUNT);

        ArrayList<User> users = blockchain.getUsers();
        ArrayList<Transaction> transactions = blockchain.getTransactions();

//        for (User user : users) {
//            System.out.println(user.getName() + " " + user.getPublicKey() + " " + user.getBalance());
//        }

        for(Transaction transaction: transactions) {
            System.out.println(transaction.getId() + " " + transaction.getFromId() + " " + transaction.getToId() + " " + transaction.getSum());
        }
    }
}

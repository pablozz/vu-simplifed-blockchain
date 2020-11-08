package blockchain;

import blockchain.utils.HashGenerator;
import blockchain.utils.RandomGenerator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int USERS_AMOUNT = 1000;

        Blockchain blockchain = new Blockchain();

        ArrayList<User> users = generateRandomUsers(USERS_AMOUNT);
        ArrayList<Transaction> transactions = generateRandomTransactions(users);

        Block block = new Block(blockchain.getLastChainBlock().getHeaderHash(), 4, transactions);
        block.mine();
    }

    private static ArrayList<User> generateRandomUsers(int usersAmount) {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < usersAmount; i++) {
            String name = "User" + (i + 1);
            String publicKey = HashGenerator.getHash(Integer.toString(i));
            double balance = RandomGenerator.getRandomDouble(1000, 1000000);
            User newUser = new User(name, publicKey, balance);

            users.add(newUser);
        }

        return users;
    }

    private static ArrayList<Transaction> generateRandomTransactions(ArrayList<User> users) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;

        for (int i = 0; i < 10000; i++) {
            User fromUser = users.get(RandomGenerator.getRandomInt(0, users.size() - 1));
            User toUser = users.get(RandomGenerator.getRandomInt(0, users.size() - 1));
            double sum = RandomGenerator.getRandomDouble(0, fromUser.getBalance());
            String fromUserPk = fromUser.getPublicKey();
            String toUserPk = toUser.getPublicKey();
            String transactionId = HashGenerator.getHash(fromUserPk + toUserPk + sum);
            transaction = new Transaction(transactionId, fromUserPk, toUserPk, sum);

            transactions.add(transaction);
        }

        return transactions;
    }
}

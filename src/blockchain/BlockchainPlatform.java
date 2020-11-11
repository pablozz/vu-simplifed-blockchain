package blockchain;

import blockchain.constants.Constants;
import blockchain.utils.HashGenerator;
import blockchain.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class BlockchainPlatform {

    private final HashMap<String, User> users;
    private final ArrayList<Transaction> transactions;
    private final Blockchain blockchain = new Blockchain();

    public BlockchainPlatform() {
        users = generateRandomUsers();
        transactions = generateRandomTransactions(users);
    }

    private static HashMap<String, User> generateRandomUsers() {
        HashMap<String, User> users = new HashMap<>();

        for (int i = 0; i < Constants.USERS_AMOUNT; i++) {
            String name = "User" + (i + 1);
            String publicKey = HashGenerator.getSHA256Hash(Integer.toString(i));
            double balance = RandomGenerator.getRandomDouble(Constants.MIN_BALANCE, Constants.MAX_BALANCE);
            User newUser = new User(name, publicKey, balance);

            users.put(publicKey, newUser);
        }

        return users;
    }

    private static ArrayList<Transaction> generateRandomTransactions(HashMap<String, User> users) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;

        for (int i = 0; i < Constants.TRANSACTIONS_AMOUNT; i++) {
            String randomFromUserKey = (String) users.keySet().toArray()[RandomGenerator.getRandomInt(0, users.size() - 1)];
            User fromUser = users.get(randomFromUserKey);

            String randomToUserKey = (String) users.keySet().toArray()[RandomGenerator.getRandomInt(0, users.size() - 1)];
            User toUser = users.get(randomToUserKey);

            double sum = RandomGenerator.getRandomDouble(0, fromUser.getBalance());
            String fromUserPk = fromUser.getPublicKey();
            String toUserPk = toUser.getPublicKey();
            String transactionId = HashGenerator.getSHA256Hash(fromUserPk + toUserPk + sum);
            transaction = new Transaction(transactionId, fromUserPk, toUserPk, sum);

            transactions.add(transaction);
        }

        return transactions;
    }

    public void mineBlocks() {
        int blockNr = 0;
        while (transactions.size() >= 100) {
            Block block = new Block(blockchain.getLastChainBlock().getHeaderHash(), 4, transactions);
            block.mine();

            ArrayList<Transaction> blockTransactions = block.getBlockTransactions();
            completeTransactions(blockTransactions);

            transactions.removeAll(blockTransactions);

            blockNr++;
//            System.out.println(blockNr + ") " + block.getTimeStamp() + ' ' + block.getHeaderHash());
            blockchain.addBlockToChain(block);
        }
    }

    private void completeTransactions(ArrayList<Transaction> blockTransactions) {
        for (Transaction blockTransaction: blockTransactions) {
            String fromUserId = blockTransaction.getFromId();
            String toUserId = blockTransaction.getToId();
            double transactionSum = blockTransaction.getSum();

            User fromUser = users.get(fromUserId);
            User toUser = users.get(toUserId);

            fromUser.reduceBalance(transactionSum);
            toUser.increaseBalance(transactionSum);

            users.put(fromUserId, fromUser);
            users.put(toUserId, toUser);
        }
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }
}


package blockchain;

import blockchain.block.Block;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final int USERS_AMOUNT = 1000;
        final int TRANSACTIONS_AMOUNT = 10000;

//        Blockchain blockchain = new Blockchain(USERS_AMOUNT, TRANSACTIONS_AMOUNT);
//
//        ArrayList<User> users = blockchain.getUsers();
//        ArrayList<Transaction> transactions = blockchain.getTransactions();

        Block block = new Block("paskutintas hashas", "merkle hashas", 1, 1);

        System.out.println(block.getHeaderHash());
    }
}

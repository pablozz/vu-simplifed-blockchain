package blockchain;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BlockchainPlatform blockchainPlatform = new BlockchainPlatform();

        blockchainPlatform.mineBlocks();

//        Blockchain blockchain = blockchainPlatform.getBlockchain();

//        printBlocks(blockchain.getChain());
    }

    private static void printBlocks(ArrayList<Block> chain) {
        System.out.println("Blockchain blocks:");
        for (int i = 1; i < chain.size(); i++) {
            System.out.println(i + ") " + chain.get(i).getTimeStamp() + " " + chain.get(i).getHeaderHash());
        }
    }
}

package blockchain;

import blockchain.Transaction;
import blockchain.constants.GlobalConstants;
import blockchain.utils.HashGenerator;
import blockchain.utils.RandomGenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Block {

    private final String prevHash;
//    private final String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    private final String merkleRootHash;
    private int nonce = -1;
    private final int difficulty;
    private final ArrayList<Transaction> blockTransactions = new ArrayList<>();

    public Block(String prevHash, int difficulty, ArrayList<Transaction> allTransactions) {
        this.prevHash = prevHash;
        this.merkleRootHash = getMerkleRootHash();
        this.difficulty = difficulty;
        populateTransactions(allTransactions);
    }

    private void populateTransactions(ArrayList<Transaction> allTransactions) {
        if (allTransactions != null && allTransactions.size() >= 100) {
            Transaction randomTransaction;
            ArrayList<Integer> randomNums = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int randomNum = RandomGenerator.getRandomInt(0, allTransactions.size());

                while (randomNums.contains(randomNum)) {
                    randomNum = RandomGenerator.getRandomInt(0, allTransactions.size());
                }

                randomTransaction = allTransactions.get(randomNum);
                randomNums.add(randomNum);
                blockTransactions.add(randomTransaction);
            }
        }
    }

    private String getMerkleRootHash() {
        if (blockTransactions.isEmpty()) {
            return null;
        } else if (blockTransactions.size() == 1) {
            return blockTransactions.get(0).getId();
        }

        ArrayList<String> merkle = new ArrayList<>();

        for (Transaction blockTransaction : blockTransactions) {
            merkle.add(blockTransaction.getId());
        }

        while (merkle.size() > 1) {
            int merkleSize = merkle.size();

            if (merkleSize % 2 != 0) {
                merkle.add(merkle.get(merkleSize - 1));
            }

            ArrayList<String> newMerkle = new ArrayList<>();

            for (int i =0; i < merkleSize; i += 2) {
                String concatHashes = merkle.get(i) + merkle.get(i + 1);
                newMerkle.add(HashGenerator.getHash(concatHashes));
            }

            merkle = newMerkle;
        }

        return merkle.get(0);
    }

    public String getHeaderHash() {
        return HashGenerator.getHash(GlobalConstants.VERSION + prevHash + merkleRootHash + nonce + difficulty);
    }

    public boolean mine() {
        boolean isMined = false;

        while (!isMined) {
            nonce++;

            String newHash = getHeaderHash();
            int suitableCharsCount = 0;

            for (int i = 0; i < difficulty; i++) {
                if(newHash.charAt(i) == '1') {
                    suitableCharsCount++;
                }
            }

            if (suitableCharsCount == difficulty) {
                System.out.println(newHash);
                isMined = true;
            }
        }

        return true;
    }
}

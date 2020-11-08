package blockchain;

import blockchain.constants.GlobalConstants;
import blockchain.utils.HashGenerator;
import blockchain.utils.RandomGenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Block {

    private final String prevHash;
    private String timeStamp;
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
        int allTransactionsSize = allTransactions != null ? allTransactions.size() : 0;

        if (allTransactions != null && allTransactionsSize >= 100) {
            Transaction randomTransaction;
            ArrayList<Integer> randomNums = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int randomIndex = RandomGenerator.getRandomInt(0, allTransactionsSize - 1);

                while (randomNums.contains(randomIndex)) {
                    randomIndex = RandomGenerator.getRandomInt(0, allTransactionsSize - 1);
                }

                randomTransaction = allTransactions.get(randomIndex);
                randomNums.add(randomIndex);
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
                newMerkle.add(HashGenerator.getSHA256Hash(concatHashes));
            }

            merkle = newMerkle;
        }

        return merkle.get(0);
    }

    public String getHeaderHash() {
        return HashGenerator.getSHA256Hash(GlobalConstants.VERSION + prevHash + merkleRootHash + nonce + difficulty);
    }

    public ArrayList<Transaction> getBlockTransactions() {
        return blockTransactions;
    }

    public void mine() {
        boolean isMined = false;

        while (!isMined) {
            nonce++;

            String newHash = getHeaderHash();
            int suitableCharsCount = 0;

            for (int i = 0; i < difficulty; i++) {
                if(newHash.charAt(i) == '0') {
                    suitableCharsCount++;
                }
            }

            if (suitableCharsCount == difficulty) {
                isMined = true;
            }
        }

        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}

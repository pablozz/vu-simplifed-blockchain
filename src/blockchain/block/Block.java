package blockchain.block;

import blockchain.Transaction;

import java.util.ArrayList;

public class Block {

    private final BlockHeader blockHeader;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Block(String prevHash, String merkleRootHash, int nonce, int difficulty) {
        blockHeader = new BlockHeader(prevHash, merkleRootHash, nonce, difficulty);
    }

    public String getHeaderHash(){
        return blockHeader.getHeaderHash();
    }
}

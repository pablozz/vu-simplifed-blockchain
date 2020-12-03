package blockchain;

import java.util.ArrayList;

public class Blockchain {

    private final ArrayList<Block> chain = new ArrayList<>();

    public Blockchain() {
        Block genesisBlock = new Block("",  0, null);
        chain.add(genesisBlock);
    }

    public ArrayList<Block> getChain() {
        return chain;
    }

    public Block getLastChainBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlockToChain(Block block) {
        chain.add(block);
    }
}

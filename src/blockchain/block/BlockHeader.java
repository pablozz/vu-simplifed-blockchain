package blockchain.block;

import blockchain.constants.GlobalConstants;
import blockchain.utils.HashGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockHeader {

    private final String prevHash;
    private final String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    private final String merkleRootHash;
    private int nonce;
    private int difficulty;

    public BlockHeader(String prevHash, String merkleRootHash, int nonce, int difficulty) {
        this.prevHash = prevHash;
        this.merkleRootHash = merkleRootHash;
        this.nonce = nonce;
        this.difficulty = difficulty;
    }

    public String getHeaderHash() {
        return HashGenerator.getHash(GlobalConstants.VERSION + prevHash + timeStamp + merkleRootHash + nonce + difficulty);
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}

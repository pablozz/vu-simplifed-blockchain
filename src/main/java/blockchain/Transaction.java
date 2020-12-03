package blockchain;

import org.bitcoinj.core.Sha256Hash;

public class Transaction {

    private final String id;
    private final String fromId;
    private final String toId;
    private final double sum;

    Transaction(String id, String fromId, String toId, double sum) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public double getSum() {
        return sum;
    }
}

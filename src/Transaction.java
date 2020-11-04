public class Transaction {

    private String id;
    private String fromId;
    private String toId;
    private double sum;

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

//    public void transact(String fromId, String toId, double sum) {
//
//    }
}

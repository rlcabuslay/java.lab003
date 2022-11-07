package lab003.Transaction;

public abstract class Transaction {
    protected float amount;
    
    public Transaction(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
    
}

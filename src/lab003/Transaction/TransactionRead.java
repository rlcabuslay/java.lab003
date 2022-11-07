package lab003.Transaction;

public class TransactionRead extends Transaction implements TransactionInterface {
    public TransactionRead(float amount) {
        super(amount);
    }

    @Override
    public String toString() {
        if(this.amount > 0) {
            return "+" + this.amount;
        }
        return String.valueOf(this.amount);
    }
}

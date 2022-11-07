package lab003.Transaction;

import lab003.Validator.TransactionValidator;

public class TransactionWithdraw extends Transaction implements TransactionInterface {
    public TransactionWithdraw(float amount, float currentBalance) {
        super(TransactionValidator.validateWithdraw(amount, currentBalance) * -1);
    }

    @Override
    public String toString() {
        return String.valueOf(this.amount);
    }

}

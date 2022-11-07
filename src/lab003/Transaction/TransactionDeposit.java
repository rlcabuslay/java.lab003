package lab003.Transaction;

import lab003.Validator.TransactionValidator;

public class TransactionDeposit extends Transaction implements TransactionInterface {
    public TransactionDeposit(float amount) {
        super(TransactionValidator.validateDeposit(amount));
    }

    @Override
    public String toString() {
        return "+" + this.amount;
    }

}

package lab003.Validator;

import static lab003.Validator.TwoDecimalPlacesValidator.*;

public class TransactionValidator {
    public static float validateWithdraw(float amount, float currentBalance) {
        if (amount > 10_000) {
            throw new IllegalArgumentException("Amount cannot be greater than 10,000");
        } else if (amount % 1 != 0) {
            throw new IllegalArgumentException("Amount should not contain decimal value");
        } else if (amount % 100 != 0) {
            throw new IllegalArgumentException("Amount should be divisible by 100");
        } else if (amount > currentBalance) {
            throw new IllegalArgumentException("Amount cannot be greater than current balance");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be greater than 0");
        }

        return amount;
    }

    public static float validateDeposit(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be greater than 0");
        } else if (!checkTwoDecimalPlaces(amount)) {
            throw new IllegalArgumentException("Amount should not have greater than 2 decimal places");
        }

        return amount;
    }
}

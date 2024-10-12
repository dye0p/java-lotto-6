package lotto.exception.model;

import lotto.exception.ErrorMessage;

public class LottoBuyerValidation {
    private static final int ONT_THOUSAND = 1000;
    private static final int ZERO = 0;

    public void validateDivide(int money) {
        if (isNotDivide(money)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_INVALID_UNIT.getErrorMessage());
        }
    }

    public void validateRange(int money) {
        if (isNotPositive(money)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_POSITIVE.getErrorMessage());
        }
    }

    public boolean isNotPositive(int money) {
        return money <= ZERO;
    }

    public boolean isNotDivide(int money) {
        return money % ONT_THOUSAND != ZERO;
    }
}

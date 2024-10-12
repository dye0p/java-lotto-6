package lotto.exception.model;

import lotto.exception.ErrorMessage;

public class BonusNumberValidation {
    private static final int MIN_NUMBER_BOUND = 1;
    private static final int MAX_NUMBER_BOUND = 45;

    public void validateBonusNumberLength(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER_BOUND || number > MAX_NUMBER_BOUND;
    }
}

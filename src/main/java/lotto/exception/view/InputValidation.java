package lotto.exception.view;

import lotto.exception.ErrorMessage;

public class InputValidation {

    private static final String NUMBERIC_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private static final String COMMA = ",";

    public void validateAmount(String input) {
        if (isEmpty(input) || isNumberic(input)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NUMBERIC.getErrorMessage());
        }
    }

    public void validWinningNumber(String winningNumber) {
        if (isNotContainsComma(winningNumber) || isEmpty(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_AS_INTEGERS_SEPARATE.getErrorMessage());
        }
    }

    public boolean isNotContainsComma(String winningNumber) {
        return !winningNumber.contains(COMMA);
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private boolean isNumberic(String input) {
        return !input.matches(NUMBERIC_REGEX);
    }

    public void validateBonusNumber(String bonusNumber) {
        if (isEmpty(bonusNumber) || isNumberic(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_AS_INTEGER.getErrorMessage());
        }
    }
}

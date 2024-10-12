package lotto.exception.model;

import lotto.exception.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class WinningNumbersValidation {

    public void validateDuplicate(Lotto winningNumber, BonusNumber bonusNumber) {
        if (isDuplicate(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getErrorMessage());
        }
    }

    private boolean isDuplicate(Lotto winningNumber, BonusNumber bonusNumber) {
        return winningNumber.containsWinningNumber(bonusNumber);
    }

}

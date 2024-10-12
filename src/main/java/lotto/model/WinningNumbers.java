package lotto.model;

import java.util.HashSet;
import lotto.exception.model.WinningNumbersValidation;

public class WinningNumbers {

    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    private WinningNumbers(Lotto winningNumber, BonusNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers create(Lotto winningNumber, BonusNumber bonusNumber) {
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private void validate(Lotto winningNumber, BonusNumber bonusNumber) {
        WinningNumbersValidation winningNumbersValidation = new WinningNumbersValidation();
        winningNumbersValidation.validateDuplicate(winningNumber, bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        HashSet<Integer> winningNumberSet = new HashSet<>(this.winningNumber.getNumbers());
        HashSet<Integer> numbers = new HashSet<>(lotto.getNumbers());

        return (int) numbers.stream()
                .filter(winningNumberSet::contains)
                .count();
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}

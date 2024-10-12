package lotto.model;

import lotto.exception.model.BonusNumberValidation;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        bonusNumberValidation.validateBonusNumberLength(number);
    }

    public static BonusNumber create(int number) {
        return new BonusNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
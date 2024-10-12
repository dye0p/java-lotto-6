package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.exception.model.LottoValidation;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.validateSize(numbers);
        lottoValidation.validateDuplicate(numbers);
        lottoValidation.validateRange(numbers);
    }

    public boolean containsWinningNumber(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getNumber());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}

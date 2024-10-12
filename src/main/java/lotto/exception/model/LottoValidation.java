package lotto.exception.model;

import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessage;

public class LottoValidation {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 45;

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_OUT_OF_SIZE.getErrorMessage());
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATE.getErrorMessage());
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE.getErrorMessage());
            }
        }
    }

    private boolean isOutOfRange(Integer number) {
        return number < MIN_BOUND || number > MAX_BOUND;
    }
}

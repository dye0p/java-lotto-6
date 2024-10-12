package lotto.util.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements RandomNumbersGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    private LottoNumberGenerator() {
    }

    public static LottoNumberGenerator create() {
        return new LottoNumberGenerator();
    }

    @Override
    public List<Integer> generatedRandomNumbers() {
        return pickUniqueRandomNumberAndSort();
    }

    private List<Integer> pickUniqueRandomNumberAndSort() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        return sorting(numbers);
    }

    private List<Integer> sorting(List<Integer> numbers) {
        List<Integer> sortNumers = new ArrayList<>(numbers);
        Collections.sort(sortNumers);
        return sortNumers;
    }
}

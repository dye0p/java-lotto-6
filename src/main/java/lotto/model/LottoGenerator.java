package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.numbergenerator.RandomNumbersGenerator;

public class LottoGenerator {
    private final RandomNumbersGenerator randomNumbersGenerator;

    private LottoGenerator(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public static LottoGenerator create(RandomNumbersGenerator randomNumbersGenerator) {
        return new LottoGenerator(randomNumbersGenerator);
    }

    public Lottos issueLottos(int amountCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lotto = 0; lotto < amountCount; lotto++) {
            lottos.add(issueLotto());
        }
        return Lottos.create(lottos);
    }

    private Lotto issueLotto() {
        List<Integer> integers = randomNumbersGenerator.generatedRandomNumbers();
        return Lotto.create(integers);
    }

}

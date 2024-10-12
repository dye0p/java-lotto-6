package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoWinningMachine {

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;

    private LottoWinningMachine(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public static LottoWinningMachine create(Lottos lottos, WinningNumbers winningNumbers) {
        return new LottoWinningMachine(lottos, winningNumbers);
    }

    public Map<LottoRank, Integer> statisticsWinning() {
        return calculateLottoMatching();
    }

    private Map<LottoRank, Integer> calculateLottoMatching() {
        Map<LottoRank, Integer> winningResult = new EnumMap<>(LottoRank.class);
        countWinningNumber(winningResult);
        return winningResult;
    }

    private void countWinningNumber(Map<LottoRank, Integer> winningResult) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = matchWinningNumberCount(lotto);
            boolean matchBonusNumber = isMatchBonusNumber(lotto);

            LottoRank lottoRank = LottoRank.matchRank(matchCount, matchBonusNumber);
            updateWinningResult(winningResult, lottoRank);
        }
    }

    private int matchWinningNumberCount(Lotto lotto) {
        return winningNumbers.matchCount(lotto);
    }

    private boolean isMatchBonusNumber(Lotto lotto) {
        return winningNumbers.isMatchBonusNumber(lotto);
    }

    private void updateWinningResult(Map<LottoRank, Integer> winningResult, LottoRank lottoRank) {
        winningResult.put(lottoRank, winningResult.getOrDefault(lottoRank, 0) + 1);
    }

    public double calculateRevenue(Map<LottoRank, Integer> winningResult) {
        double totalWinningAmount = winningResult.entrySet().stream()
                .mapToDouble(this::sumWinningMoney)
                .sum();

        return (totalWinningAmount / amountMoney()) * 100;
    }

    private int amountMoney() {
        return lottos.getLottosSize() * 1000;
    }

    private long sumWinningMoney(Entry<LottoRank, Integer> lottoRank) {
        return lottoRank.getKey().getWinningAmount() * lottoRank.getValue();
    }
}

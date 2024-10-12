package lotto.model;

public enum LottoRank {
    FIVE_RANK("3개 일치 (5,000원)", 5000L),
    FOUR_RANK("4개 일치 (50,000원)", 50000L),
    THREE_RANK("5개 일치 (1,500,000원)", 1500000L),
    SECOND_RANK("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000L),
    FIRST_RNAK("6개 일치 (2,000,000,000원)", 2000000000L),
    NO("3개 이하 일치", 0L);

    private final String description;
    private final long winningAmount;

    LottoRank(String description, long winningAmount) {
        this.description = description;
        this.winningAmount = winningAmount;
    }

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST_RNAK;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND_RANK;
        }
        if (matchCount == 5) {
            return THREE_RANK;
        }
        if (matchCount == 4) {
            return FOUR_RANK;
        }
        if (matchCount == 3) {
            return FIVE_RANK;
        }
        return NO;
    }

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}

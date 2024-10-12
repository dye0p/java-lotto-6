package lotto.model;

import lotto.exception.model.LottoBuyerValidation;

public class LottoBuyer {
    private static final int ONT_THOUSAND = 1000;

    private final int money;

    private LottoBuyer(int money) {
        validate(money);
        this.money = money;
    }

    public static LottoBuyer create(int money) {
        return new LottoBuyer(money);
    }

    private void validate(int money) {
        LottoBuyerValidation lottoBuyerValidation = new LottoBuyerValidation();
        lottoBuyerValidation.validateDivide(money);
        lottoBuyerValidation.validateRange(money);
    }

    public int ticketCount() {
        return this.money / ONT_THOUSAND;
    }

    public int getMoney() {
        return money;
    }
}

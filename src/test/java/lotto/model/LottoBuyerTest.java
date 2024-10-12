package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {

    @DisplayName("구입 금액이 1000원 단위로 나누어지지 않으면 예외를 발생한다.")
    @Test
    void createAmountByDivideOneThousand() {
        //given
        int amountCash = 2500;

        //when //then
        assertThatThrownBy(() -> LottoBuyer.create(amountCash))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위여야 합니다.");
    }
}
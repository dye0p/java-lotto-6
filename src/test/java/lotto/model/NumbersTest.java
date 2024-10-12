package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("당첨번호의 개수가 6이 아닌경우 예외를 발생한다.")
    @Test
    void validWinningNumberSize() {
        //given //when //then
        assertThatThrownBy(() -> WinningNumbers.create(Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)), null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 중복된 경우 예외를 발생한다.")
    @Test
    void vlaidWinningNumbersDuplicate() {
        //given //when //then
        assertThatThrownBy(() -> WinningNumbers.create(Lotto.create(List.of(1, 1, 3, 4, 5, 6)), null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
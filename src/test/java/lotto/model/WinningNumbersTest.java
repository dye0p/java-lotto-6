package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("보너스 번호와 당첨번호가 중복된다면 예외를 발생한다.")
    @Test
    void validBonusNumberAndWinningNumberDuplicate() {
        //given
        Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(1);

        //when //then
        assertThatThrownBy(() -> WinningNumbers.create(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호와 당첨번호를 비교해 일치하는 개수를 반환한다")
    @Test
    void matchCount() {
        //given
        Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        Lotto winningNumber = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);

        WinningNumbers winningNumbers = WinningNumbers.create(winningNumber, bonusNumber);

        //when
        int matchCount = winningNumbers.matchCount(lotto);

        //then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또번호와 보너스번호가 일치한다면 true 반환한다.")
    @Test
    void isMatchBonusNumber() {
        //given
        Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        Lotto winningNumber = Lotto.create(List.of(7, 8, 9, 10, 11, 12));
        BonusNumber bonusNumber = BonusNumber.create(1);

        WinningNumbers winningNumbers = WinningNumbers.create(winningNumber, bonusNumber);

        //when
        boolean matchBonusNumber = winningNumbers.isMatchBonusNumber(lotto);

        //then
        assertThat(matchBonusNumber).isEqualTo(true);
    }
}
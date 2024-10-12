package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1부터 45까지의 범위가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validBonusNumberSize(int number) {
        //given //when //then
        assertThatThrownBy(() -> BonusNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
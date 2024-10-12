package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("구입한 개수만큼 로또를 발행한다.")
    @Test
    void issueLottoByAmountCount() {
        //given
        int amountCount = 3;

        //when
        LottoGenerator lottoGenerator = LottoGenerator.create(() -> List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = lottoGenerator.issueLottos(amountCount);

        //then
        assertThat(lottos.getLottosSize()).isEqualTo(3);
    }

}
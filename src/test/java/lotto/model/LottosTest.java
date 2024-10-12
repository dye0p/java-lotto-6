package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또의 개수를 반환한다.")
    @Test
    void getLottoByLottoIndexSize() {
        //given
        List<Lotto> lottoris = List.of(
                Lotto.create(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.create(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.create(List.of(13, 14, 15, 16, 17, 18))
        );
        Lottos lottos = Lottos.create(lottoris);

        //when
        int lottosSize = lottos.getLottosSize();

        //then
        assertThat(lottosSize).isEqualTo(3);
    }

    @DisplayName("로또중 특정 순서의 로또를 반환한다.")
    @Test
    void getLottoByLottoIndex() {
        //given
        List<Lotto> lottoris = List.of(
                Lotto.create(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.create(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.create(List.of(13, 14, 15, 16, 17, 18))
        );
        Lottos lottos = Lottos.create(lottoris);
        int ticketIndex = 2;

        //when
        List<Integer> lottoByTicketCount = lottos.getLottoByLottoIndex(ticketIndex);

        //then
        assertThat(lottoByTicketCount).isEqualTo(List.of(13, 14, 15, 16, 17, 18));
    }
}
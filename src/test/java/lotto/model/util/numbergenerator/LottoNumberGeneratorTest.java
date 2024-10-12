package lotto.model.util.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.numbergenerator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("1부터 45까지 중복되지 않는 6자리 숫자 리스트를 발행한다.")
    @Test
    void creatRandomNumbers() {
        //given
        LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.create();

        //when
        List<Integer> numbers = lottoNumberGenerator.generatedRandomNumbers();

        //then
        assertThat(numbers).hasSize(6);
    }

}
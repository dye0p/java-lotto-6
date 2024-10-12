package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {

    List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Integer> getLottoByLottoIndex(int lottoIndex) {
        return this.lottos.get(lottoIndex).getNumbers();
    }
}

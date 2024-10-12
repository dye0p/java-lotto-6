package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Convertor {
    private static final String COMMA = ",";

    public Lotto toList(String winningNumber) {
        String[] split = splitToString(winningNumber);
        return Lotto.create(addToList(split));
    }

    private List<Integer> addToList(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winning : split) {
            winningNumbers.add(Integer.parseInt(winning));
        }
        return winningNumbers;
    }

    private String[] splitToString(String winningNumber) {
        return winningNumber.split(COMMA);
    }
}

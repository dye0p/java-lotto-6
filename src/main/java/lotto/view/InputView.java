package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.view.InputValidation;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.util.Convertor;

public class InputView {
    private final InputValidation inputValidation = new InputValidation();

    public int inputAmount() {
        String input = Console.readLine();
        inputValidation.validateAmount(input);
        return Integer.parseInt(input);
    }

    public Lotto inputWinningNumber() {
        String winningNumber = Console.readLine();
        inputValidation.validWinningNumber(winningNumber);
        return convertToList(winningNumber);
    }

    private Lotto convertToList(String winningNumber) {
        Convertor convertor = new Convertor();
        return convertor.toList(winningNumber);
    }

    public BonusNumber inputBonusNumber() {
        String bonusNumber = Console.readLine();
        inputValidation.validateBonusNumber(bonusNumber);
        return BonusNumber.create(Integer.parseInt(bonusNumber));
    }
}


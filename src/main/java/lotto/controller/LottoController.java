package lotto.controller;

import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoGenerator;
import lotto.model.LottoRank;
import lotto.model.LottoWinningMachine;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.numbergenerator.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static LottoController create() {
        return new LottoController();
    }

    public void runLotto() {
        Lottos lottos = generatorLottos(inputAmount());
        WinningNumbers winningNumbers = inputWinningNumbers();
        LottoWinningMachine lottoWinningMachine = LottoWinningMachine.create(lottos, winningNumbers);

        Map<LottoRank, Integer> winningResult = lottoWinningMachine.statisticsWinning();
        printWinningResult(winningResult);
        outputView.printRevenue(lottoWinningMachine.calculateRevenue(winningResult));
    }

    private void printWinningResult(Map<LottoRank, Integer> lottoRankIntegerMap) {
        outputView.printWinningStatisticsMessage();
        outputView.printWinningResult(lottoRankIntegerMap);
    }

    private WinningNumbers inputWinningNumbers() {
        Lotto winningNumber = inputWinningNumber();
        outputView.printBonusNumberMessage();
        return tryWinningNumber(winningNumber);
    }

    private Lotto inputWinningNumber() {
        outputView.printWinningNumberMessage();
        return tryInputWinningNumber();
    }

    private Lottos generatorLottos(LottoBuyer lottoBuyer) {
        LottoGenerator lottoGenerator = LottoGenerator.create(LottoNumberGenerator.create());
        Lottos lottos = lottoGenerator.issueLottos(lottoBuyer.ticketCount());
        outputView.printLottoTickets(lottos);
        return lottos;
    }

    private LottoBuyer inputAmount() {
        outputView.printInputAmountMessage();
        LottoBuyer lottoBuyer = tryInputAmount();
        getAmount(lottoBuyer);
        return lottoBuyer;
    }

    private LottoBuyer tryInputAmount() {
        while (true) {
            try {
                int amount = inputView.inputAmount();
                return LottoBuyer.create(amount);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WinningNumbers tryWinningNumber(Lotto winningNumber) {
        while (true) {
            try {
                BonusNumber bonusNumber = inputView.inputBonusNumber();
                return WinningNumbers.create(winningNumber, bonusNumber);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Lotto tryInputWinningNumber() {
        while (true) {
            try {
                return inputView.inputWinningNumber();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void getAmount(LottoBuyer lottoBuyer) {
        outputView.printSuccessAmountMessage(lottoBuyer.ticketCount());
    }
}

package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String WINNING_RESULT_MESSAGE = NEW_LINE + "당첨 통계" + NEW_LINE + "---";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = NEW_LINE + "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String INPUT_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요";
    private static final String DASH = " - ";

    public void printInputAmountMessage() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public void printSuccessAmountMessage(int ticketCount) {
        System.out.println(NEW_LINE + String.format("%d", ticketCount) + "개를 구매했습니다.");
    }

    public void printLottoTickets(Lottos lottoTicket) {
        StringBuilder sb = new StringBuilder();
        appendLottos(lottoTicket, sb);
        System.out.print(sb);
    }

    private void appendLottos(Lottos lottoTicket, StringBuilder sb) {
        for (int ticketCount = 0; ticketCount < lottoTicket.getLottosSize(); ticketCount++) {
            sb.append(lottoTicket.getLottoByLottoIndex(ticketCount)).append(NEW_LINE);
        }
    }

    public void printWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        System.out.println(WINNING_RESULT_MESSAGE);
    }

    public void printWinningResult(Map<LottoRank, Integer> winningResult) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getWinningAmount() > 0) {
                System.out.println(rank.getDescription() + DASH + winningResult.getOrDefault(rank, 0) + "개");
            }
        }
    }

    public void printRevenue(double revenue) {
        String formatRevenu = String.format("%.1f", revenue);
        System.out.print("총 수익률은 " + formatRevenu + "%입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
